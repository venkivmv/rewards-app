export class Request {
  static post = function (url, data, callback) {
    const options = {
      method: "POST",
      headers: Request.getHeaders(),
      body: JSON.stringify(data),
    };
    Request.callApi(url, options, callback);
  };

  static get = function (url, callback) {
    const options = {
      method: "GET",
      headers: Request.getHeaders(),
    };
    Request.callApi(url, options, callback);
  };

  static callApi = function (url, requestOptions, cb) {
    window.loader(true);
    let status;
    fetch(url, requestOptions)
      .then((response) => {
        status = response.status;
        return response.text();
      })
      .then((result) => cb(result, null, status))
      .catch((error) => cb(null, error, status))
      .finally(() => {
        window.loader();
      });
  };

  static getHeaders = function () {
    const headers = new Headers();
    headers.append("Content-Type", "application/json");
    headers.append("Accept", "*/*");
    headers.append("Sec-Fetch-Site", "same-site");
    headers.append("Sec-Fetch-Dest", "empty");
    return headers;
  };
}
