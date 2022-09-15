import { get, put, post, remove } from '@/helpers/http';

const BASE_PATH = 'usuarios';

export function fetchUsuario() {
  return get(`${BASE_PATH}`);
}

export function getUsuario(id) {
  return get(`/${BASE_PATH}/${id}`);
}

export function updateUsuario(objetivo) {
  return put(`/${BASE_PATH}/${objetivo.id}`, objetivo);
}

export function createUsuario(objetivo) {
  return post(`${BASE_PATH}`, objetivo);
}

export function removeUsuario(objetivo) {
  return remove(`/${BASE_PATH}/${objetivo.id}`);
}
