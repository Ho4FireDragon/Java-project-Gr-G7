import { Link } from 'react-router-dom'
import Logo from '../components/Logo'
import { config } from '../configs'
import Navbar from './Navbar'
import { Button } from '@nextui-org/react'

function Header() {
    const headerbar = [
        { label: 'About us', path: config.routes.about },
        { label: 'Faq', path: config.routes.faq },
        { label: 'Our services', path: config.routes.our_services },
    ]

    return (
        <header>
            <div className="container py-4 grid grid-cols-[150px_1fr] gap-3">
                <Link to={'/'}>
                    <Logo width={200} height={82} />
                </Link>
                <div className="flex items-center justify-end gap-2.5">
                    <ul className="flex items-center justify-start">
                        {headerbar.map((item, index) => (
                            <li key={index}>
                                <a href={item.path} className="text-[21px] leading-[80px] font-medium uppercase px-[21px] text-primary">
                                    {item.label}
                                </a>
                            </li>
                        ))}
                    </ul>
                    <Button className="text-[21px] leading-[80px] font-medium uppercase px-[21px] text-white" color="warning">
                        Request Appointment
                    </Button>
                </div>
            </div>
            <Navbar />
        </header>
    )
}

export default Header
