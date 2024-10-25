import { config } from '../configs'
// Layout
import EmptyLayout from '../components/layouts/EmptyLayout'
import HomePage from '../pages/HomePage'
import AboutPage from '../pages/AboutPage'
import AppointmentPage from '../pages/AppointmentPage'
// Auth
import LoginPage from '../pages/LoginPage'
import RegisterPage from '../pages/RegisterPage'

export const globalRoutes = [
    { path: config.routes.home, element: HomePage },
    { path: config.routes.about, element: AboutPage },
    { path: config.routes.appointment, element: AppointmentPage },

    { path: config.routes.login, element: LoginPage, layout: EmptyLayout },
    { path: config.routes.register, element: RegisterPage, layout: EmptyLayout },
]
