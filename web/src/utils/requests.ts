export interface BaseResponse {
    errorDescription: string
}

export async function requestToken(username: string, password: string) {
    return 'test-token' // TODO implement
}

export async function getAuthenticated<T extends BaseResponse>(url: string, params: {[prop: string]: string}): Promise<T> {
    let paramsBuilder = new URLSearchParams();
    for (const prop in params)
        paramsBuilder.set(prop, params[prop])

    let _params = paramsBuilder.toString();
    try {
        let response = await fetch(`${url}?${_params}`);
        return JSON.parse(await response.json());
    }
    catch (e) {
        return processError(e) // TODO ugly
    }
}

function processError<T>(e: any): T {
    return null
}

export async function postAuthenticated(url: string, payload: object) {

}
