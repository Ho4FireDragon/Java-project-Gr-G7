import axiosClient from './axiosClient'
import Cookies from 'universal-cookie'

const cookies = new Cookies(null, { path: '/' })

const bookingApi = {
    createBooking: async (newBooking) => {
        const url = '/bookings/create'
        return await axiosClient.post(url, newBooking, {
            headers: {
                Authorization: `Bearer ${cookies.get('token')}`,
            },
        })
    },
    getBooking: async (params) => {
        const url = '/bookings'
        return await axiosClient.get(url, {
            params,
            headers: {
                Authorization: `Bearer ${cookies.get('token')}`,
            },
        })
    },
}

export default bookingApi
