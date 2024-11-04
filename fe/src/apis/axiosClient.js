import axios from 'axios'
import queryString from 'query-string'

export const API_URL = import.meta.env.VITE_API_URL

const axiosClient = axios.create({
    baseURL: API_URL,
    headers: {
        'Cache-Control': 'no-cache',
        'Content-Type': 'application/x-www-form-urlencoded',
        'Access-Control-Allow-Origin': '*',
        'content-type': 'application/json',
    },
    paramsSerializer: (params) => queryString.stringify(params),
})

axiosClient.interceptors.request.use(async (config) => {
    // Handle token here ...
    const token = 'token here'
    config.headers.Authorization = token ? `Bearer ${token}` : ''

    return config
})

export default axiosClient
