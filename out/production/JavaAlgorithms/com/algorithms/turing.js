var solution = function (cards,k) {
    let usedValues = new Map();


    for (let i = 0; i < cards.length; i++) {
        for (let j = 0; j < cards.length; j++) {

            if(cards[i]+cards[j] === k){
                usedValues.set(card[i],1);
                usedValues.set(card)
                cards = cards.filter(item => item !== cards[i] || cards !== cards[j])
            }
        }

    }

    return -1;
}