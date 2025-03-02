function lemonDistribution() {
    let lemons = parseInt(prompt("Enter the number of lemons in hand:"));

    console.log("No of lemon in hand: " + lemons);

    let god1 = 7;
    let god2 = 7;
    let god3 = 7;

    if (lemons >= god1) {
        console.log("God 1: 7 offered");
        lemons -= god1;
    } else {
        console.log("God 1: " + lemons + " need");
        console.log("Shortage: " + (god1 + god2 + god3 - lemons));
        return;
    }

    if (lemons >= god2) {
        console.log("God 2: 7 offered");
        lemons -= god2;
    } else {
        console.log("God 2: " + lemons + " need");
        console.log("Shortage: " + (god2 + god3 - lemons));
        return;
    }

    if (lemons >= god3) {
        console.log("God 3: 7 offered");
        lemons -= god3;
        console.log("Surplus: " + lemons);
    } else {
        console.log("God 3: having " + lemons + " need " + (god3 - lemons));
        console.log("Shortage: " + (god3 - lemons));
    }
}

lemonDistribution();