import Swal from 'sweetalert2'
import authApi from '../apis/auth.api'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { useAuthContext } from '../contexts/AuthContext'

export const useCustomerLogin = () => {
    const navigate = useNavigate()
    const [loading, setLoading] = useState(false)
    const { setAuthUser } = useAuthContext()

    const customerLogin = async (authInfo) => {
        try {
            setLoading(true)
            const response = await authApi.customerLogin(authInfo)
            const { status, data } = response
            if (status === 200) {
                setAuthUser(data)
                localStorage.setItem('__user-information', JSON.stringify(data))
                Swal.fire({
                    title: 'Successfully!',
                    text: 'Register successfully !!!',
                    confirmButtonText: 'Go to Home',
                }).then((result) => {
                    if (result.isConfirmed) {
                        navigate('/')
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

    return { loading, customerLogin }
}
