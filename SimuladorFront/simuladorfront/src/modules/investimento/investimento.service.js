import * as TipoInvestimentoResource from '@/modules/investimento/investimento.resource';

export function fetchTipoInvestimento() {
  return new Promise((resolve, reject) =>
    TipoInvestimentoResource
      .fetchTipoInvestimento()
      .then(({ data }) => {
        resolve({
          data,
        });
      })
      .catch(err => reject(err)));
}

export function getTipoInvestimento(TipoInvestimentoId) {
  return new Promise((resolve, reject) =>
    TipoInvestimentoResource
      .getTipoInvestimento(TipoInvestimentoId)
      .then(({ data }) => {
        if (!data) {
          reject(new Error('not_found'));
        }
        resolve({ data });
      })
      .catch(err => reject(err)));
}

export function saveTipoInvestimento(TipoInvestimento) {
  const errors = null;
  return new Promise((resolve, reject) =>
    (errors ? reject(errors) : getTipoInvestimentoaveAction(TipoInvestimento)(TipoInvestimento)
      .then(({ data }) => resolve(data))
      .catch(err => reject(err))));
}

export function removeTipoInvestimento(TipoInvestimento) {
  return new Promise((resolve, reject) =>
    TipoInvestimentoResource
      .removeTipoInvestimento(TipoInvestimento.id)
      .then(() => {
        resolve();
      })
      .catch(err => {
        reject(err);
      }));
}

function getTipoInvestimentoaveAction(TipoInvestimento) {
  return TipoInvestimento.id ? TipoInvestimentoResource.updateTipoInvestimento : TipoInvestimentoResource.createTipoInvestimento;
}
