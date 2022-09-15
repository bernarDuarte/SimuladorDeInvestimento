import { get, post, put, remove } from '@/helpers/http';

const BASE_PATH = 'TipoInvestimento';

export function fetchTipoInvestimento() {
  return get(`${BASE_PATH}`);
}

export function getTipoInvestimento(TipoInvestimentoId) {
  return get(`${BASE_PATH}/${TipoInvestimentoId}`);
}

export function createTipoInvestimento(TipoInvestimento) {
  return post(`${BASE_PATH}`, { ...TipoInvestimento });
}

export function updateTipoInvestimento(TipoInvestimento) {
  return put(`${BASE_PATH}/${TipoInvestimento.id}`, TipoInvestimento);
}

export function removeTipoInvestimento(id) {
  return remove(`${BASE_PATH}/${id}`);
}
