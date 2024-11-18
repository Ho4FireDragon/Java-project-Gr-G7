import Swal from 'sweetalert2'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { config } from '../configs'
import { useCookies } from 'react-cookie'
import bookingApi from '../apis/booking.api'

export const useCreateBooking = () => {
    const navigate = useNavigate()
    const [loading, setLoading] = useState(false)
    const [cookie, setCookie] = useCookies(['token'])

    const createBooking = async (newBooking) => {
        try {
            setLoading(true)
            const response = await bookingApi.createBooking(newBooking)
            console.log(response)

            const { status, data } = response
            if (status === 200) {
                Swal.fire({
                    title: 'Successfully!',
                    text: 'Login successfully !!!',
                    confirmButtonText: 'Go to Home',
                }).then((result) => {
                    if (result.isConfirmed) {
                        navigate(config.routes.home)
                    }
                })
            }
        } catch (error) {
            Swal.fire({
                title: 'Error!',
                text: error,
                color: 'error',
                iconColor: 'error',
            })
        } finally {
            setLoading(false)
        }
    }

    return { loading, createBooking }
}
