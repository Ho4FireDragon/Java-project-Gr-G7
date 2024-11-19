import axiosClient from './axiosClient'
import Cookies from 'universal-cookie'

const cookies = new Cookies(null, { path: '/' })

const staffApi = {
    getStaffs: async (params) => {
        const url = '/staff'
        return await axiosClient.get(url, {
            params,
            headers: {
                Authorization: `Bearer ${cookies.get('token')}`,
            },
        })
    },
}

export default staffApi
