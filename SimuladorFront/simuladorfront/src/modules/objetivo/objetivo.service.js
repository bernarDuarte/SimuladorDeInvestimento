import * as objetivoResource from '@/modules/objetivo/objetivo.resource';

export function fetchObjetivo() {
  return new Promise((resolve, reject) =>
    objetivoResource
      .fetchObjetivo()
      .then(({ data }) => {
        resolve({
          data,
        });
      })
      .catch(err => reject(err)));
}

export function getObjetivos(id) {
  return new Promise((resolve, reject) =>
    objetivoResource
      .getObjetivos(id)
      .then(({ data }) => {
        if (!data) {
          reject(new Error('not_found'));
        }
        resolve({ data });
      })
      .catch(err => reject(err)));
}

export function saveObjetivo(objetivo) {
  const errors = null;
  return new Promise((resolve, reject) =>
    (errors ? reject(errors) : getObjetivoSaveAction(objetivo)(objetivo)
      .then(({ data }) => resolve(data))
      .catch(err => reject(err))));
}

export function createObjetivo(objetivo) {
  return new Promise((resolve, reject) =>
    objetivoResource
      .createObjetivo(objetivo)
      .then(({ data }) => {
        resolve(data);
      })
      .catch(err => reject(err)));
}

export function updateObjetivo(objetivo) {
  return new Promise((resolve, reject) =>
    objetivoResource
      .updateObjetivo(objetivo)
      .then(({ data }) => {
        resolve(data);
      })
      .catch(err => reject(err)));
}

export function removeObjetivo(objetivo) {
  return new Promise((resolve, reject) =>
    objetivoResource
      .removeObjetivo(objetivo)
      .then(({ data }) => {
        resolve(data);
      })
      .catch(err => reject(err)));
}

function getObjetivoSaveAction(objetivo) {
  return objetivo.id ? objetivoResource.updateObjetivo : objetivoResource.createObjetivo;
}
