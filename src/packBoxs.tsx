import { packBox } from './packBox';

export const packBoxs = (articles: number[]) => {
    let boxs = [];
    if (articles.length !== 0) {
        console.info("Début du traitement");
        // Faire un tri descendant
        let itemsSorted: number[] = articles.sort().reverse();
        // Emballer les cartons jusqu'au dernier article
        while (itemsSorted.length !== 0) {
            // Emballer carton par carton
            boxs.push(packBox(itemsSorted) + "/");
        }
        console.info("Fin du traintement. Nombre de boite est  ", boxs.length);
    }
    return boxs;
}