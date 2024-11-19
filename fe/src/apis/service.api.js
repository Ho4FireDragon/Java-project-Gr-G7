import axiosClient from './axiosClient'

const serviceApi = {
    getServices: async (params) => {
        const url = '/services'
        return await axiosClient.get(url, { params })
    },
    createService: async (newService) => {
        const url = '/services/create'
        return await axiosClient.post(url, newService)
    },
}

export default serviceApi
