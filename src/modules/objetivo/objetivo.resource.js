import { get, put, post, remove } from '@/helpers/http';

const BASE_PATH = 'objetivo';

export function fetchObjetivo() {
  return get(`${BASE_PATH}`);
}

export function getObjetivos(id) {
  return get(`/${BASE_PATH}/usuario/${id}`);
}

export function updateObjetivo(objetivo) {
  return put(`/${BASE_PATH}/${objetivo.id}`, objetivo);
}

export function createObjetivo(objetivo) {
  return post(`${BASE_PATH}`, objetivo);
}

export function removeObjetivo(objetivo) {
  return remove(`/${BASE_PATH}/${objetivo.id}`);
}
