import { config } from '../configs'

// Layouts
import EmptyLayout from '../components/layouts/EmptyLayout'
import DefaultLayout from '../components/layouts/DefaultLayout'
// Public Page
import HomePage from '../pages/HomePage'
import AboutPage from '../pages/AboutPage'
import AppointmentPage from '../pages/AppointmentPage'
import FaqPage from '../pages/FaqPage'
import Services from '../pages/services'
// Auth
import LoginPage from '../pages/LoginPage'
import RegisterPage from '../pages/RegisterPage'
// Roles Page
import UserPage from '../pages/UserPage'
import Admin from '../pages/Admin'
import Staff from '../pages/Staff'

export const globalRoutes = [
    { path: config.routes.home, element: HomePage, layout: DefaultLayout },
    { path: config.routes.about, element: AboutPage, layout: DefaultLayout },
    { path: config.routes.appointment, element: AppointmentPage, layout: DefaultLayout },
    { path: config.routes.faq, element: FaqPage, layout: DefaultLayout },
    { path: config.routes.services, element: Services, layout: DefaultLayout },
    { path: config.routes.login, element: LoginPage, layout: EmptyLayout },
    { path: config.routes.register, element: RegisterPage, layout: EmptyLayout },
    { path: config.routes.staff, element: Staff, layout: EmptyLayout },
    { path: config.routes.admin, element: Admin, layout: EmptyLayout },
    { path: config.routes.user, element: UserPage },
]
