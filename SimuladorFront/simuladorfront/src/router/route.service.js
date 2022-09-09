
export function createEmptyComponent(controller){
    return controller('router-view');
}

function redirectByRouter($router,path){
  if($router){
    $router.push(path);
    return;
  }
  window.location = path;
}

function goBackHistory($router){
  if($router){
    $router.go(-1);
    return;
  }
  window.history.back;
}