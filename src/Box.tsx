import { packBoxs } from './packBoxs';

const Box = () => {

    let items: number[] = [1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3];
    let boxs = packBoxs(items);

    return (
        <form >
            <div>
                <output>Cartons </output>
                <div>{boxs}</div>
            </div>
        </form>
    );
}

export default Box;