import { Link } from 'react-router-dom'
import Logo from '../components/Logo'
import { config } from '../configs'
import Navbar from './Navbar'
import { Avatar, Button, Divider } from '@nextui-org/react'
import { useAuthContext } from '../contexts/AuthContext'
import { isEmptyObject } from '../ultils/isEmptyObject'

function Header() {
    const { authUser } = useAuthContext()
    const headerbar = [
        { label: 'About us', path: config.routes.about },
        { label: 'Faq', path: config.routes.faq },
        { label: 'services', path: config.routes.services },
    ]

    return (
        <header>
            <div className="container py-4 grid grid-cols-[150px_1fr] gap-3">
                <Link to={'/'} title="Go to Home">
                    <Logo width={200} height={82} />
                </Link>
                <div className="flex items-center justify-end gap-2.5">
                    <ul className="mr-2.5 flex items-center justify-start">
                        {headerbar.map((item, index) => (
                            <li key={index}>
                                <Link to={item.path} className="text-[21px] leading-[80px] font-medium uppercase px-[21px] text-primary">
                                    {item.label}
                                </Link>
                            </li>
                        ))}
                    </ul>
                    <Button className="text-[21px] leading-[80px] font-medium uppercase text-white px-0" color="warning">
                        <Link to={config.routes.appointment} className="px-[21px]">
                            Request Appointment
                        </Link>
                    </Button>
                    <Divider orientation="vertical" className="h-12 mx-2.5" />
                    {isEmptyObject(authUser) && (
                        <Button className="group text-[21px] leading-[80px] font-medium uppercase px-0" color="primary" variant="ghost">
                            <Link to={config.routes.login} className="px-[21px] text-primary group-hover:text-white">
                                Login
                            </Link>
                        </Button>
                    )}
                    {!isEmptyObject(authUser) && (
                        <div className="flex items-center justify-start gap-2.5">
                            <p>
                                Hi <span className="font-semibold">{authUser.firstname + ' ' + authUser.lastname}</span> !
                            </p>
                            <Avatar name={authUser.firstname} color="primary" />
                        </div>
                    )}
                </div>
            </div>
            <Navbar />
        </header>
    )
}

export default Header
