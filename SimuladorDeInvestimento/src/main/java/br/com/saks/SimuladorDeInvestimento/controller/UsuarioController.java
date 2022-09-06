package br.com.saks.SimuladorDeInvestimento.controller;


import br.com.saks.SimuladorDeInvestimento.config.JwtTokenUtil;
import br.com.saks.SimuladorDeInvestimento.model.JwtResponse;
import br.com.saks.SimuladorDeInvestimento.model.Usuario;
import br.com.saks.SimuladorDeInvestimento.repository.UsuarioRepository;
import br.com.saks.SimuladorDeInvestimento.service.JwtUserDetailsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;
    
    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
    
    @GetMapping(value="/{id}")
    public Optional<Usuario> listarPeloId(@PathVariable Long id) {
        return usuarioRepository.findById(id);
    }
    
    @PostMapping
    public Usuario usuario(@RequestBody Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }
    
    @RequestMapping(value = "/criar", method = RequestMethod.POST)
    public ResponseEntity<?> adicionar(@RequestBody Usuario usuario) {
        try {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String senha = usuario.getSenha();
            usuario.setSenha(encoder.encode(usuario.getSenha()));

            Usuario usuarioSave = usuarioRepository.save(usuario);
            authenticate(usuarioSave.getEmail(), senha);
            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(usuarioSave.getEmail());
            final String token = jwtTokenUtil.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "EMAIL_DUPLICADO");
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return usuarioRepository.findById(id)
                .map(record -> {
                    record.setNome(usuario.getNome());
                    record.setEmail(usuario.getEmail());
                    record.setSenha(usuario.getSenha());
                    record.setTelefone(usuario.getTelefone());
                    record.setObjetivos(usuario.getObjetivos());
                    record.setStatus(usuario.getStatus());
                    Usuario usuarioUpdated = usuarioRepository.save(record);
                    return ResponseEntity.ok().body(usuarioUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(record-> {
                    usuarioRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
