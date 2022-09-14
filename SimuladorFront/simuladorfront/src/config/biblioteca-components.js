import Vue from 'vue';
/*
import BibliotecaIcon from '@/components/icon/Icon.vue';
import BibliotecaForm from '@/components/form/Form.vue';
import BibliotecaInput from '@/components/input/Input.vue';
import BibliotecaTextarea from '@/components/input/Textarea.vue';
import BibliotecaNavbar from '@/components/navbar/Navbar.vue';
import BibliotecaTopbar from '@/components/topbar/Topbar.vue';
import BibliotecaPagination from '@/components/pagination/Pagination.vue';
import BibliotecaSelect from '@/components/select/Select.vue';
import BibliotecaModal from '@/components/modal/Modal.vue';
import BibliotecaModalConfirm from '@/components/modal/ModalConfirm.vue';
import BibliotecaModalDelete from '@/components/modal/ModalDelete.vue';
import BibliotecaAvatar from '@/components/avatar/Avatar.vue';
import BibliotecaInvisible from '@/components/invisible/Invisible.vue';
import BibliotecaImage from '@/components/image/Image.vue';
import BibliotecaButton from '@/components/button/Button.vue';
import BibliotecaEmpty from '@/components/empty/Empty.vue';

// Containers
import BibliotecaRow from '@/components/container/Row.vue';
import BibliotecaCol from '@/components/container/Column.vue';
import BibliotecaContainer from '@/components/container/Container.vue';

// Typography
import BibliotecaP from '@/components/typography/Paragraph.vue';
import BibliotecaSmall from '@/components/typography/Small.vue';
import BibliotecaHeader from '@/components/typography/Header.vue';
*/
import TopBar from '@/components/topbar/TopBar.vue';
import SimuladorInput from '@/components/input/input.vue';
import TextArea from '@/components/input/textArea.vue';
import SimuladorButton from '@/components/button/button.vue';
import Forms from '@/components/forms/forms.vue';
import SimuladorIcon from '@/components/icon/icon.vue';

const components = {
  TopBar,
  SimuladorInput,
  TextArea,
  SimuladorButton,
  Forms,
  SimuladorIcon,
};

Object.entries(components).forEach(([name, component]) => Vue.component(name, component));
