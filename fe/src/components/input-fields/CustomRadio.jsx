import { Radio, cn } from '@nextui-org/react'

export const CustomRadio = (props) => {
    const { children, ...otherProps } = props

    return (
        <Radio
            {...otherProps}
            classNames={{
                base: cn(
                    'inline-flex m-0 bg-content1 hover:bg-content2 items-center justify-between',
                    'flex-row-reverse max-w-[500px] cursor-pointer rounded-lg gap-4 p-4 border-2 border-transparent',
                    'data-[selected=true]:border-primary'
                ),
            }}
        >
            {children}
        </Radio>
    )
}
