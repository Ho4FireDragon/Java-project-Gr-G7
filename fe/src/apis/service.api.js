import axiosClient from './axiosClient'

const serviceApi = {
    createService: async (newService) => {
        const url = '/services/create'
        return await axiosClient.post(url, newService)
    },
}

export default serviceApi
