import PropTypes from 'prop-types'
import { Button, Modal, ModalBody, ModalContent, ModalFooter, ModalHeader } from '@nextui-org/react'
import ChooseSchedule from '../ChooseSchedule'
import { useState } from 'react'

StaffChangeScheduleModal.propTypes = {
    isOpen: PropTypes.bool.isRequired,
    staffData: PropTypes.object.isRequired,
    onOpenChange: PropTypes.func.isRequired,
}

function StaffChangeScheduleModal({ staffData, isOpen, onOpenChange }) {
    const [staffSchedule, setStaffSchedule] = useState(staffData.staffschedule)

    const handleChangeSchedule = () => {
        console.log(staffSchedule)
    }

    return (
        <Modal isOpen={isOpen} onOpenChange={onOpenChange}>
            <ModalContent>
                {(onClose) => (
                    <>
                        <ModalHeader className="flex flex-col gap-1">Change Schedule</ModalHeader>
                        <ModalBody>
                            <ChooseSchedule staffSchedule={staffData.staffschedule ?? []} setStaffSchedule={setStaffSchedule} />
                        </ModalBody>
                        <ModalFooter>
                            <Button color="danger" type="button" variant="light" onPress={onClose}>
                                Cancel
                            </Button>
                            <Button
                                color="primary"
                                onClick={() => {
                                    handleChangeSchedule()
                                    onClose()
                                }}
                            >
                                Save
                            </Button>
                        </ModalFooter>
                    </>
                )}
            </ModalContent>
        </Modal>
    )
}

export default StaffChangeScheduleModal
