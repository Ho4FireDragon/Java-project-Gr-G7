import * as Yup from 'yup'
import { useFormik } from 'formik'
import { Input } from '@nextui-org/input'
import { Button } from '@nextui-org/react'
import { Link } from 'react-router-dom'
import { useCustomerRegister } from '../../hooks/useCustomerRegister'

const RegisterValidationSchema = Yup.object().shape({
    firstName: Yup.string().min(2, 'Too Short!').max(20, 'Too Long!').required('Required'),
    lastName: Yup.string().min(2, 'Too Short!').max(20, 'Too Long!').required('Required'),
    phone: Yup.string().min(9, 'Phone number is invalid!').max(9, 'Phone number is invalid!').required('Required'),
    email: Yup.string().email('Invalid email').min(2, 'Too Short!').max(50, 'Too Long!').required('Required'),
    address: Yup.string().min(1, 'Too Short!').max(255, 'Too Long!').required('Required'),
    password: Yup.string().required('Required'),
    confirmPassword: Yup.string()
        .required('Required')
        .oneOf([Yup.ref('password'), null], 'Password must match'),
})

function RegisterForm() {
    const { customerRegister } = useCustomerRegister()
    const formik = useFormik({
        initialValues: {
            firstName: '',
            lastName: '',
            email: '',
            phone: '',
            address: '',
            password: '',
            confirmPassword: '',
        },
        validationSchema: RegisterValidationSchema,
        onSubmit: (values) => {
            const newCustomer = {
                firstname: values.firstName,
                lastname: values.lastName,
                email: values.email,
                phone: values.phone,
                address: values.address,
                password: values.password,
            }
            // const newCustomer = {
            //     firstname: 'John',
            //     lastname: 'Doe',
            //     email: 'john.doe@example.com',
            //     phone: '1234567890',
            //     address: '123 Main St',
            //     password: 'password123',
            // }
            customerRegister(newCustomer)
        },
    })

    return (
        <form onSubmit={formik.handleSubmit} className="w-full flex flex-col gap-5">
            <div className="flex items-center justify-between gap-5">
                <Input
                    isRequired
                    label="First Name"
                    name="firstName"
                    id="firstName"
                    type="text"
                    onChange={formik.handleChange}
                    value={formik.values.firstName}
                    errorMessage={formik.errors.firstName}
                    isInvalid={formik.errors.firstName ? true : false}
                />
                <Input
                    isRequired
                    label="Last Name"
                    name="lastName"
                    id="lastName"
                    type="text"
                    onChange={formik.handleChange}
                    value={formik.values.lastName}
                    errorMessage={formik.errors.lastName}
                    isInvalid={formik.errors.lastName ? true : false}
                />
            </div>
            <Input
                isRequired
                label="Email"
                name="email"
                id="email"
                type="email"
                onChange={formik.handleChange}
                value={formik.values.email}
                errorMessage={formik.errors.email}
                isInvalid={formik.errors.email ? true : false}
            />
            <Input
                isRequired
                label="Phone Number"
                name="phone"
                id="phone"
                type="number"
                onChange={formik.handleChange}
                value={formik.values.phone}
                errorMessage={formik.errors.phone}
                isInvalid={formik.errors.phone ? true : false}
            />
            <Input
                isRequired
                label="Address"
                name="address"
                id="address"
                onChange={formik.handleChange}
                value={formik.values.address}
                errorMessage={formik.errors.address}
                isInvalid={formik.errors.address ? true : false}
            />
            <Input
                isRequired
                label="Password"
                name="password"
                id="password"
                type="password"
                onChange={formik.handleChange}
                value={formik.values.password}
                errorMessage={formik.errors.password}
                isInvalid={formik.errors.password ? true : false}
            />
            <Input
                isRequired
                label="Confirm Password"
                name="confirmPassword"
                id="confirmPassword"
                type="password"
                onChange={formik.handleChange}
                value={formik.values.confirmPassword}
                errorMessage={formik.errors.confirmPassword}
                isInvalid={formik.errors.confirmPassword ? true : false}
            />
            <p className="text-gray-800 text-sm">
                Does your have an account?{' '}
                <Link to={'/login'} className="underline text-blue-600 underline-offset-2">
                    Login
                </Link>
            </p>
            <Button type="submit" className="font-semibold">
                Register
            </Button>
        </form>
    )
}

export default RegisterForm
