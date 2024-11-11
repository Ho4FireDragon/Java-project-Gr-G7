import { config } from '../configs'
// Layouts
import EmptyLayout from '../components/layouts/EmptyLayout'
import DefaultLayout from '../components/layouts/DefaultLayout'
import HomePage from '../pages/HomePage'
import AboutPage from '../pages/AboutPage'
import AppointmentPage from '../pages/AppointmentPage'
// Auth
import LoginPage from '../pages/LoginPage'
import RegisterPage from '../pages/RegisterPage'
import Admin from '../pages/Admin'

import FaqPage from '../pages/FaqPage'
import services from '../pages/services'
import UserPage from '../pages/UserPage'

export const globalRoutes = [
    { path: config.routes.home, element: HomePage, layout: DefaultLayout },
    { path: config.routes.about, element: AboutPage, layout: DefaultLayout },
    { path: config.routes.appointment, element: AppointmentPage, layout: DefaultLayout },
    { path: config.routes.faq, element: FaqPage, layout: DefaultLayout },
    { path: config.routes.services, element: services, layout: DefaultLayout },
    { path: config.routes.login, element: LoginPage, layout: EmptyLayout },
    { path: config.routes.register, element: RegisterPage, layout: EmptyLayout },
    { path: config.routes.admin, element: Admin }, 
    { path: config.routes.user, element: UserPage }, 
]
