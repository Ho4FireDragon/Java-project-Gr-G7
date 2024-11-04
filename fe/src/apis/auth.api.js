import axiosClient from './axiosClient'

const authApi = {
    customerRegister: async (newCustomer) => {
        const url = '/customers/create'
        return await axiosClient.post(url, newCustomer)
    },
    customerLogin: async (authInfo) => {
        const url = `/auth/login-customer`
        return await axiosClient.post(url, authInfo)
    },
    logout: async (params) => {
        const url = `users/logout/:id`
        return await axiosClient.get(url, { params })
    },
}

export default authApi
