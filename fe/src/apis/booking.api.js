import axiosClient from './axiosClient'

const bookingApi = {
    createBooking: async (newBooking) => {
        const url = '/bookings/create'
        return await axiosClient.post(url, newBooking)
    },
}

export default bookingApi
