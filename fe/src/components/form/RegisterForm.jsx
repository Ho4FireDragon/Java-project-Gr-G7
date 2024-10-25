import * as Yup from 'yup'
import { useFormik } from 'formik'
import { Input } from '@nextui-org/input'
import { Button } from '@nextui-org/react'
import { Link } from 'react-router-dom'

const RegisterSchema = Yup.object().shape({
    fullname: Yup.string().min(2, 'Too Short!').max(50, 'Too Long!').required('Required'),
    email: Yup.string().email('Invalid email').min(2, 'Too Short!').max(50, 'Too Long!').required('Required'),
    password: Yup.string().required('Required'),
    confirmPassword: Yup.string()
        .required('Required')
        .oneOf([Yup.ref('password'), null], 'Password must match'),
})

function RegisterForm() {
    const formik = useFormik({
        initialValues: {
            fullname: '',
            email: '',
            password: '',
            confirmPassword: '',
        },
        validationSchema: RegisterSchema,
        onSubmit: (values) => {
            console.log(JSON.stringify(values, null, 2))
        },
    })

    return (
        <form onSubmit={formik.handleSubmit} className="w-full flex flex-col gap-5">
            <Input
                isRequired
                label="Full Name"
                name="fullname"
                type="text"
                onChange={formik.handleChange}
                value={formik.values.fullname}
                errorMessage={formik.errors.fullname}
                isInvalid={formik.errors.fullname ? true : false}
            />
            <Input
                isRequired
                label="Email"
                name="email"
                type="email"
                onChange={formik.handleChange}
                value={formik.values.email}
                errorMessage={formik.errors.email}
                isInvalid={formik.errors.email ? true : false}
            />
            <Input
                isRequired
                label="Password"
                name="password"
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
