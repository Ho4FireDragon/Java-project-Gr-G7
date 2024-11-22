import PropTypes from 'prop-types'
import { Checkbox, Table, TableBody, TableCell, TableColumn, TableHeader, TableRow } from '@nextui-org/react'
import { formatMoney } from '../../ultils/formatMoney'
import bookingApi from '../../apis/booking.api'
import Swal from 'sweetalert2'

StaffBookingTable.propTypes = {
    data: PropTypes.array.isRequired,
}

function StaffBookingTable({ data }) {
    const handleChangeIsVisited = async (bookingId, state) => {
        try {
            const response1 = await bookingApi.updateAppointment(bookingId)
            const response2 = await bookingApi.updatePaymentStatus(bookingId)
            console.log(response1)
            console.log(response2)

            const { status } = response1
            if (status === 200) {
                Swal.fire({
                    title: 'Successfully!',
                    text: 'Set Is Visited successfully !!!',
                    confirmButtonText: 'OK',
                })
            }
        } catch (error) {
            Swal.fire({
                title: 'Error!',
                text: error,
                color: 'error',
                iconColor: 'error',
            })
        }
    }

    return (
        <Table aria-label="Example static collection table">
            <TableHeader>
                <TableColumn>CODE</TableColumn>
                <TableColumn>Booking Date</TableColumn>
                <TableColumn>Customer</TableColumn>
                <TableColumn>Service</TableColumn>
                <TableColumn>Payment Status</TableColumn>
                <TableColumn>Total Price</TableColumn>
                <TableColumn>Is Visited</TableColumn>
            </TableHeader>
            <TableBody>
                {data.map((item) => (
                    <TableRow key={item.id}>
                        <TableCell>{item.id}</TableCell>
                        <TableCell>{item.bookingDate}</TableCell>
                        <TableCell>
                            <div className="flex flex-col gap-1">
                                <p className="font-semibold text-lg">{item.customer.firstname}</p>
                                <div className="flex flex-col gap-1 text-sm">
                                    <p>Phone: {item.customer.phone}</p>
                                    <p>Address: {item.customer.address}</p>
                                </div>
                            </div>
                        </TableCell>
                        <TableCell>
                            <div className="flex flex-col gap-2">
                                <p className="text-xs">#{item.service.productcode}</p>
                                <p className="font-medium">{item.service.nameservice}</p>
                            </div>
                        </TableCell>
                        <TableCell>{item.paymentStatus === true ? <p className="text-green-500">Paid</p> : <p className="text-red-500">Unpaid</p>}</TableCell>
                        <TableCell>
                            <p className="text-xl text-red-500 font-bold">{formatMoney(item.totalprice ?? 0)}</p>
                        </TableCell>
                        <TableCell>
                            <Checkbox
                                isSelected={item.appointment}
                                onValueChange={() => {
                                    handleChangeIsVisited(item.id, item.appointment)
                                }}
                            />
                        </TableCell>
                    </TableRow>
                ))}
            </TableBody>
        </Table>
    )
}

export default StaffBookingTable
