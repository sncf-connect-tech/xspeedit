import { packBox } from './packBox';

test('test emballage un carton', () => {
    const articles = [6, 5, 4];
    const boxReceived = packBox(articles);
    expect(boxReceived).toEqual([4, 6]);
});
