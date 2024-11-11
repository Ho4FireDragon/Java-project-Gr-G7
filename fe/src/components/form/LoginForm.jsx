import * as Yup from 'yup'
import { useFormik } from 'formik'
import { Input } from '@nextui-org/input'
import { Button } from '@nextui-org/react'
import { Link, useNavigate } from 'react-router-dom'

const LoginSchema = Yup.object().shape({
    email: Yup.string().email('Invalid email').min(2, 'Too Short!').max(50, 'Too Long!').required('Required'),
    password: Yup.string().required('Required'),
})

function LoginForm() {
    const navigate = useNavigate(); 
    const formik = useFormik({
        initialValues: {
            email: '',
            password: '',
        },
        validationSchema: LoginSchema,
        onSubmit: (values) => {
            if (values.email === 'admin@gmail.com' && values.password === '1234567') {
                navigate('/admin');
            } else if (LoginSchema.isValidSync(values)) {
                navigate('/user');
            } else {
                alert('Invalid credentials');
            }
        },
    });

    return (
        <form onSubmit={formik.handleSubmit} className="w-full flex flex-col gap-5">
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
            <p className="text-gray-800 text-sm">
                Does your have an account?{' '}
                <Link to={'/register'} className="underline text-blue-600 underline-offset-2">
                    Register
                </Link>
            </p>
            <Button type="submit" className="font-semibold">
                Login
            </Button>
        </form>
    );
}

export default LoginForm;
