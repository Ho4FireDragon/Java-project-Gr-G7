import Hero from '../components/home-sections/Hero'
import OurServices from '../components/home-sections/OurServices'
import Terminator from '../components/home-sections/Terminator'

function HomePage() {
    return (
        <div className="w-full h-full">
            <Hero />
            <Terminator />
            <OurServices />
        </div>
    )
}

export default HomePage
