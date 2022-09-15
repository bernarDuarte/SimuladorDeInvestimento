import Cookies from 'js-cookie';
import * as cookies from '@/helpers/cookies/cookie';

const MOCK = {
  name: '',
  value: 123,
  expires: 1,
  path: '/',
};

describe('Cookies', () => {
  beforeEach(() => {
    Cookies.get = jest.fn();
    Cookies.set = jest.fn();
    Cookies.remove = jest.fn();
  });

  it('should get correct cookies by name', () => {
    cookies.getCookie(MOCK.name);
    expect(Cookies.get).toHaveBeenCalledWith(MOCK.name);
  });

  it('should set complete cookies', () => {
    cookies.setCookie(MOCK.name, MOCK.value, MOCK.expires, MOCK.path);
    expect(Cookies.set).toHaveBeenCalledWith(MOCK.name, MOCK.value, {
      expires: MOCK.expires,
      path: MOCK.path,
    });
  });

  it('should list all cookiess', () => {
    cookies.getAllCookies();
    expect(Cookies.get).toHaveBeenCalledWith();
  });

  it('should remove the cookies', () => {
    cookies.removeCookie(MOCK.name);
    expect(Cookies.remove).toHaveBeenCalledWith(MOCK.name, { path: MOCK.path });
  });
});
