import { config } from '../configs'
import HomePage from '../pages/HomePage'
import AboutPage from '../pages/AboutPage'
import AppointmentPage from '../pages/AppointmentPage'

export const globalRoutes = [
    { path: config.routes.home, element: HomePage },
    { path: config.routes.about, element: AboutPage },
    { path: config.routes.appointment, element: AppointmentPage },
]
