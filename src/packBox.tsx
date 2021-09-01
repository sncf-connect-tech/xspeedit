export const packBox = (itemsSorted: number[]): number[] => {
    let box: number[] = [];
    // Remplir le carton tant qu'il n'est pas rempli 
    while (itemsSorted[itemsSorted.length - 1] + itemsSorted[0] + countItemsBox(box) <= 10) {
        box.push(itemsSorted[itemsSorted.length - 1])
        itemsSorted.pop();
    }
    box.push(itemsSorted[0]);
    itemsSorted.shift();
    return box;
}

const countItemsBox = (box: number[]) => {
    return box.reduce((a, b) => a + b, 0);
}