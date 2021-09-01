import { packBoxs } from './packBoxs';

test('test emballage tout les articles', () => {
    let articles: number[] = [1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3];
    const boxsReceived = packBoxs(articles);
    expect(boxsReceived).toEqual([[4, 6], [1, 9], [1, 8], [2, 8], [3, 7], [4, 6], [6], [5, 5]]);
});
