import StaffBookingTable from '../components/tables/StaffBookingTable'

function StaffBookingPage() {
    return (
        <div className="p-5">
            <h1 className="text-2xl font-semibold">Staff Bookings Management</h1>
            <div className="border-t mt-5 pt-10">
                <StaffBookingTable />
            </div>
        </div>
    )
}

export default StaffBookingPage
