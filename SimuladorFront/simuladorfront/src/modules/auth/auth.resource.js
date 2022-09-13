import { post } from '@/helpers/http';

export function login(username, password) {
  return post('/auhtenticate', { username, password });
}
export function registrar(usuario) {
  return post('/usuarios/criar', { usuario });
}
