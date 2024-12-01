package org.example.fit_plan.controllers;


import javafx.scene.shape.Polygon;

import java.util.Arrays;
import java.util.List;

public class MuscleGroupMan {

  public static Polygon trapsLeftFront = new Polygon(
          127.00, 79.60,
          123.80, 82.80,
          119.80, 84.40,
          114.20, 86.80,
          108.60, 89.20,
          103.00, 93.20,
          107.80, 94.00,
          112.60, 95.60,
          115.00, 94.80,
          119.00, 97.20,
          122.20, 96.40,
          125.40, 94.00,
          127.80, 92.40,
          127.80, 79.60

          );


  public static Polygon trapsRightFront = new Polygon(
          162.20, 79.60,
          162.20, 82.00,
          162.20, 86.00,
          162.20, 89.20,
          162.20, 93.20,
          163.80, 94.80,
          167.00, 95.60,
          169.40, 97.20,
          170.20, 97.20,
          172.60, 96.40,
          179.80, 94.80,
          186.20, 94.00,
          186.20, 93.20,
          183.80, 90.80,
          179.80, 88.40,
          173.40, 86.80,
          170.20, 85.20,
          167.80, 83.60,
          162.20, 78.80,
          162.20, 81.20
          );

  public static Polygon chestFront = new Polygon(
          144.60, 102.80,
          140.60, 98.80,
          136.60, 98.00,
          127.00, 95.60,
          119.80, 97.20,
          115.00, 99.60,
          110.20, 102.00,
          105.40, 107.60,
          95.00, 119.60,
          91.00, 123.60,
          86.20, 127.60,
          82.20, 130.00,
          86.20, 130.80,
          87.80, 130.80,
          92.60, 133.20,
          95.80, 137.20,
          100.60, 141.20,
          104.60, 143.60,
          112.60, 147.60,
          118.20, 147.60,
          126.20, 147.60,
          132.60, 145.20,
          135.80, 141.20,
          139.00, 138.80,
          141.40, 137.20,
          143.00, 134.00,
          144.60, 130.80,
          147.00, 133.20,
          148.60, 136.40,
          149.40, 138.00,
          152.60, 142.00,
          158.20, 145.20,
          164.60, 147.60,
          170.20, 149.20,
          174.20, 148.40,
          179.80, 148.40,
          183.00, 146.00,
          185.40, 144.40,
          189.40, 142.00,
          192.60, 138.80,
          195.00, 136.40,
          197.40, 134.00,
          200.60, 132.40,
          202.20, 130.80,
          206.20, 130.00,
          206.20, 129.20,
          199.00, 125.20,
          195.00, 120.40,
          188.60, 112.40,
          183.80, 106.00,
          179.80, 102.00,
          174.20, 99.60,
          171.00, 98.80,
          165.40, 97.20,
          156.60, 95.60,
          152.60, 97.20,
          148.60, 98.00,
          146.20, 100.40,
          145.40, 103.60
          );


  public static Polygon shoulderLeftFront = new Polygon(
          119.00, 97.20,
          114.20, 95.60,
          108.60, 94.00,
          104.60, 94.00,
          99.80, 94.00,
          94.20, 96.40,
          90.20, 97.20,
          87.00, 98.80,
          83.80, 100.40,
          79.80, 105.20,
          76.60, 108.40,
          73.40, 116.40,
          71.00, 123.60,
          69.40, 127.60,
          68.60, 133.20,
          72.60, 133.20,
          75.80, 130.80,
          77.40, 130.80,
          79.00, 130.80,
          85.40, 128.40,
          87.80, 126.00,
          93.40, 121.20,
          99.00, 115.60,
          101.40, 110.80,
          105.40, 106.80,
          109.40, 102.80,
          112.60, 100.40,
          118.20, 98.00
  );

public static Polygon shoulderRightFront = new Polygon(
        171.80, 96.40,
        175.80, 94.80,
        181.40, 94.80,
        187.80, 94.00,
        194.20, 95.60,
        199.80, 97.20,
        206.20, 101.20,
        210.20, 105.20,
        213.40, 109.20,
        215.80, 115.60,
        218.20, 122.00,
        219.80, 124.40,
        221.40, 134.00,
        217.40, 131.60,
        215.00, 130.80,
        210.20, 130.00,
        206.20, 130.00,
        200.60, 126.80,
        195.00, 119.60,
        191.00, 116.40,
        186.20, 110.00,
        183.80, 106.00,
        179.00, 102.00,
        177.40, 101.20,
        171.80, 97.20
);

public static Polygon abdominalsFront = new Polygon(
        144.60, 147.60,
        144.60, 146.00,
        143.80, 145.20,
        139.80, 144.40,
        135.80, 144.40,
        131.00, 146.80,
        123.80, 150.00,
        120.60, 151.60,
        121.40, 153.20,
        121.40, 158.80,
        123.00, 162.80,
        123.00, 168.40,
        123.00, 178.00,
        123.00, 187.60,
        123.80, 198.80,
        124.60, 206.00,
        124.60, 211.60,
        124.60, 215.60,
        125.40, 220.40,
        127.80, 228.40,
        134.20, 241.20,
        139.80, 250.00,
        144.60, 253.20,
        149.40, 249.20,
        152.60, 245.20,
        156.60, 239.60,
        161.40, 229.20,
        163.80, 218.00,
        165.40, 213.20,
        165.40, 197.20,
        167.80, 182.00,
        167.80, 171.60,
        167.80, 166.00,
        167.80, 162.00,
        170.20, 154.00,
        167.00, 150.80,
        159.80, 146.00,
        151.80, 143.60,
        147.00, 144.40,
        146.20, 145.20,
        145.40, 146.80
);

public static Polygon obliqueLeftFront = new Polygon(
        91.00, 132.40,
        92.60, 136.40,
        93.40, 143.60,
        92.60, 147.60,
        91.00, 153.20,
        94.20, 159.60,
        97.40, 167.60,
        101.40, 176.40,
        105.40, 185.20,
        105.40, 186.80,
        106.20, 197.20,
        103.00, 222.00,
        107.80, 222.80,
        112.60, 222.80,
        115.00, 219.60,
        118.20, 214.80,
        119.80, 210.80,
        120.60, 205.20,
        121.40, 200.40,
        119.80, 198.00,
        119.00, 193.20,
        119.80, 186.80,
        122.20, 171.60,
        122.20, 166.00,
        122.20, 163.60,
        121.40, 162.00,
        104.60, 145.20,
        98.20, 139.60,
        95.00, 135.60,
        92.60, 134.00,
        92.60, 133.20
);

public static Polygon obliqueRightFront = new Polygon(
        198.20, 133.20,
        194.20, 136.40,
        167.80, 162.80,
        167.80, 164.40,
        168.60, 172.40,
        169.40, 177.20,
        170.20, 185.20,
        171.00, 191.60,
        169.40, 198.80,
        169.40, 204.40,
        170.20, 212.40,
        173.40, 217.20,
        175.00, 219.60,
        178.20, 222.80,
        181.40, 222.80,
        184.60, 222.80,
        187.80, 222.80,
        183.80, 194.80,
        184.60, 190.80,
        185.40, 185.20,
        187.00, 179.60,
        191.80, 171.60,
        195.00, 163.60,
        196.60, 156.40,
        197.40, 154.00,
        197.40, 151.60,
        197.40, 147.60,
        196.60, 141.20,
        196.60, 137.20,
        197.40, 133.20
        );

public static Polygon bicepsLeftFront = new Polygon(
        67.80, 134.00,
        66.20, 137.20,
        63.00, 139.60,
        59.00, 147.60,
        55.00, 154.80,
        54.20, 159.60,
        54.20, 163.60,
        53.40, 171.60,
        55.00, 176.40,
        58.20, 179.60,
        62.20, 181.20,
        65.40, 181.20,
        71.00, 178.80,
        74.20, 174.80,
        79.80, 167.60,
        81.40, 164.40,
        83.80, 162.00,
        86.20, 158.80,
        90.20, 154.00,
        91.80, 150.80,
        94.20, 144.40,
        93.40, 139.60,
        93.40, 135.60,
        91.80, 133.20,
        87.80, 131.60,
        85.40, 130.00,
        81.40, 130.00,
        75.80, 130.80,
        73.40, 131.60,
        68.60, 134.00
);

public static Polygon bicepsRightFront = new Polygon(
        220.60, 133.20,
        213.40, 130.80,
        206.20, 130.80,
        202.20, 130.80,
        199.00, 132.40,
        195.80, 134.00,
        196.60, 138.80,
        196.60, 143.60,
        197.40, 148.40,
        198.20, 150.80,
        199.00, 154.00,
        201.40, 157.20,
        205.40, 162.00,
        210.20, 166.80,
        214.20, 172.40,
        218.20, 177.20,
        223.80, 180.40,
        229.40, 181.20,
        234.20, 179.60,
        235.80, 174.80,
        235.80, 166.80,
        235.00, 159.60,
        233.40, 154.00,
        231.00, 147.60,
        228.60, 144.40,
        224.60, 138.00,
        222.20, 134.80,
        220.60, 134.00
        );

public static Polygon forearmLeftFront = new Polygon(
        53.40, 160.40,
        50.20, 166.00,
        46.20, 170.80,
        41.40, 176.40,
        37.40, 181.20,
        36.60, 186.00,
        35.00, 186.00,
        32.60, 189.20,
        30.20, 195.60,
        26.20, 204.40,
        17.40, 226.00,
        19.00, 226.80,
        21.40, 231.60,
        23.80, 232.40,
        27.80, 232.40,
        30.20, 229.20,
        33.40, 225.20,
        38.20, 222.00,
        45.40, 215.60,
        50.20, 210.80,
        54.20, 206.80,
        57.40, 202.00,
        60.60, 196.40,
        63.00, 190.80,
        64.60, 186.80,
        68.60, 182.80,
        71.80, 176.40,
        67.00, 178.80,
        62.20, 181.20,
        56.60, 178.00,
        53.40, 175.60,
        53.40, 171.60,
        54.20, 168.40,
        54.20, 163.60,
        55.00, 160.40
);

public static Polygon forearmRightFront = new Polygon(
        218.20, 177.20,
        222.20, 182.80,
        226.20, 189.20,
        227.80, 193.20,
        231.00, 198.80,
        233.40, 203.60,
        236.60, 207.60,
        241.40, 214.00,
        246.20, 217.20,
        251.00, 221.20,
        255.80, 226.00,
        258.20, 230.00,
        259.80, 232.40,
        264.60, 232.40,
        267.80, 231.60,
        271.00, 230.00,
        271.80, 224.40,
        268.60, 217.20,
        264.60, 206.00,
        260.60, 198.80,
        257.40, 190.00,
        255.00, 183.60,
        251.00, 178.00,
        245.40, 173.20,
        243.00, 169.20,
        238.20, 164.40,
        236.60, 162.00,
        236.60, 159.60,
        236.60, 163.60,
        236.60, 168.40,
        235.80, 172.40,
        235.00, 176.40,
        231.80, 179.60,
        229.40, 181.20,
        224.60, 181.20,
        222.20, 179.60,
        219.00, 178.80
);

public static Polygon quadricepsLeftFront = new Polygon(
        103.00, 224.40,
        100.60, 233.20,
        99.80, 243.60,
        97.40, 257.20,
        95.00, 270.00,
        92.60, 277.20,
        91.00, 293.20,
        90.20, 302.80,
        91.00, 323.60,
        93.40, 335.60,
        95.00, 345.20,
        95.80, 350.80,
        97.40, 354.00,
        101.40, 354.80,
        105.40, 354.00,
        107.00, 354.80,
        108.60, 358.80,
        111.00, 364.40,
        114.20, 368.40,
        115.80, 368.40,
        119.80, 367.60,
        123.00, 365.20,
        125.40, 358.80,
        127.00, 354.80,
        129.40, 350.80,
        129.40, 345.20,
        131.00, 334.00,
        132.60, 324.40,
        135.00, 318.00,
        137.40, 312.40,
        139.80, 305.20,
        141.40, 298.80,
        143.80, 292.40,
        143.80, 286.80,
        143.80, 285.20,
        143.80, 275.60,
        141.40, 275.60,
        138.20, 272.40,
        135.80, 270.00,
        133.40, 262.00,
        130.20, 254.00,
        129.40, 246.80,
        126.20, 241.20,
        121.40, 234.80,
        116.60, 230.00,
        109.40, 225.20,
        102.20, 224.40
);

public static Polygon quadricepsRightFront = new Polygon(
        187.00, 223.60,
        182.20, 224.40,
        177.40, 226.80,
        171.80, 231.60,
        167.00, 236.40,
        163.80, 240.40,
        159.80, 248.40,
        159.00, 255.60,
        155.00, 263.60,
        155.00, 268.40,
        151.80, 273.20,
        147.00, 277.20,
        146.20, 277.20,
        146.20, 281.20,
        146.20, 290.00,
        147.00, 296.40,
        149.40, 305.20,
        152.60, 312.40,
        155.00, 318.80,
        156.60, 326.00,
        159.00, 334.00,
        160.60, 340.40,
        160.60, 346.00,
        162.20, 354.00,
        166.20, 361.20,
        167.80, 364.40,
        173.40, 367.60,
        175.80, 367.60,
        179.00, 366.00,
        180.60, 361.20,
        181.40, 358.00,
        182.20, 354.00,
        183.80, 354.00,
        187.00, 354.00,
        191.00, 354.00,
        192.60, 350.80,
        195.00, 342.80,
        198.20, 327.60,
        199.00, 308.40,
        199.00, 292.40,
        198.20, 275.60,
        194.20, 263.60,
        191.80, 248.40,
        189.40, 242.00,
        188.60, 229.20,
        187.00, 223.60
);

public static Polygon calfLeftFront = new Polygon(
        94.20, 374.00,
        92.60, 380.40,
        91.00, 385.20,
        88.60, 393.20,
        87.00, 402.00,
        87.80, 410.00,
        88.60, 421.20,
        90.20, 430.00,
        91.00, 437.20,
        91.80, 447.60,
        91.80, 454.00,
        92.60, 466.00,
        91.00, 473.20,
        95.80, 474.00,
        100.60, 474.00,
        106.20, 473.20,
        108.60, 473.20,
        109.40, 468.40,
        108.60, 461.20,
        108.60, 454.80,
        110.20, 448.40,
        111.00, 439.60,
        114.20, 432.40,
        115.80, 427.60,
        116.60, 422.80,
        119.00, 419.60,
        120.60, 415.60,
        121.40, 408.40,
        120.60, 403.60,
        119.00, 394.00,
        118.20, 389.20,
        118.20, 382.80,
        119.00, 379.60,
        115.80, 381.20,
        115.00, 384.40,
        111.80, 384.40,
        107.80, 386.80,
        107.00, 386.00,
        103.80, 383.60,
        101.40, 382.00,
        100.60, 379.60,
        98.20, 375.60,
        95.80, 374.00,
        93.40, 374.00
);

public static Polygon calfRightFront = new Polygon(
        171.00, 381.20,
        172.60, 388.40,
        171.00, 394.00,
        171.00, 402.80,
        170.20, 406.00,
        168.60, 412.40,
        169.40, 415.60,
        173.40, 421.20,
        175.80, 428.40,
        177.40, 436.40,
        179.00, 447.60,
        181.40, 457.20,
        181.40, 464.40,
        181.40, 468.40,
        187.80, 469.20,
        192.60, 470.00,
        198.20, 470.00,
        199.00, 470.00,
        197.40, 466.00,
        198.20, 462.80,
        197.40, 455.60,
        198.20, 447.60,
        199.00, 438.00,
        201.40, 428.40,
        202.20, 418.80,
        202.20, 414.00,
        202.20, 406.80,
        201.40, 398.80,
        200.60, 392.40,
        199.80, 387.60,
        197.40, 378.80,
        195.00, 375.60,
        192.60, 375.60,
        190.20, 380.40,
        187.80, 383.60,
        184.60, 385.20,
        180.60, 386.00,
        176.60, 385.20,
        172.60, 382.80,
        171.80, 382.00
);

public static Polygon trapsUpBack = new Polygon(
        610.20, 86.00,
        607.80, 87.60,
        605.40, 89.20,
        603.80, 89.20,
        600.60, 90.00,
        597.40, 91.60,
        591.80, 94.80,
        595.00, 94.80,
        599.80, 96.40,
        602.20, 98.80,
        604.60, 101.20,
        607.00, 104.40,
        608.60, 104.40,
        610.20, 105.20,
        616.60, 105.20,
        625.40, 103.60,
        633.40, 102.00,
        640.60, 103.60,
        645.40, 103.60,
        652.60, 106.80,
        656.60, 106.00,
        659.00, 103.60,
        661.40, 102.80,
        663.80, 101.20,
        666.20, 98.80,
        669.40, 96.40,
        672.60, 95.60,
        675.80, 93.20,
        675.80, 94.00,
        671.00, 90.80,
        663.80, 87.60,
        660.60, 86.00,
        657.40, 86.00,
        654.20, 85.20,
        649.40, 85.20,
        646.20, 84.40,
        639.80, 84.40,
        633.40, 86.00,
        623.00, 84.40,
        619.00, 84.40,
        615.00, 85.20,
        610.20, 86.00
);

public static Polygon trapsDownBack = new Polygon(
        607.80, 104.40,
        609.40, 107.60,
        612.60, 114.80,
        617.40, 124.40,
        622.20, 135.60,
        629.40, 154.80,
        630.20, 159.60,
        632.60, 161.20,
        635.80, 161.20,
        637.40, 158.00,
        642.20, 144.40,
        647.00, 131.60,
        654.20, 116.40,
        657.40, 110.80,
        659.00, 106.80,
        661.40, 102.80,
        658.20, 103.60,
        657.40, 104.40,
        655.00, 105.20,
        648.60, 104.40,
        639.00, 102.80,
        634.20, 102.80,
        628.60, 103.60,
        621.40, 104.40,
        617.40, 104.40,
        615.00, 105.20,
        610.20, 106.00,
        607.80, 104.40
);

public static Polygon shoulderLeftBack = new Polygon(
        605.40, 101.20,
        599.80, 98.00,
        595.80, 95.60,
        591.80, 94.80,
        587.80, 95.60,
        583.00, 95.60,
        575.80, 98.80,
        570.20, 102.00,
        565.40, 106.80,
        562.20, 111.60,
        560.60, 114.80,
        558.20, 120.40,
        556.60, 127.60,
        559.00, 126.80,
        562.20, 126.00,
        566.20, 126.00,
        570.20, 124.40,
        575.00, 124.40,
        579.00, 122.80,
        584.60, 119.60,
        589.40, 116.40,
        592.60, 112.40,
        597.40, 108.40,
        601.40, 106.00,
        603.00, 105.20,
        604.60, 101.20
);

public static Polygon shoulderRightBack = new Polygon(
        662.20, 101.20,
        666.20, 106.00,
        674.20, 112.40,
        683.00, 118.80,
        688.60, 122.80,
        691.00, 122.80,
        698.20, 126.00,
        703.00, 125.20,
        707.00, 126.00,
        710.20, 128.40,
        710.20, 128.40,
        710.20, 124.40,
        708.60, 117.20,
        703.80, 110.00,
        699.00, 103.60,
        692.60, 98.80,
        687.00, 97.20,
        681.40, 95.60,
        678.20, 95.60,
        673.40, 95.60,
        668.60, 95.60,
        665.40, 99.60,
        662.20, 101.20
);

public static Polygon latsLeftBack = new Polygon(
        605.40, 102.00,
        599.80, 107.60,
        589.40, 114.80,
        583.80, 120.40,
        578.20, 122.80,
        577.40, 124.40,
        577.40, 130.00,
        579.00, 139.60,
        579.80, 146.00,
        578.20, 148.40,
        580.60, 154.00,
        582.20, 162.00,
        584.60, 166.80,
        587.00, 172.40,
        589.40, 178.00,
        591.80, 186.80,
        591.80, 194.00,
        587.80, 231.60,
        589.40, 230.80,
        592.60, 228.40,
        598.20, 224.40,
        603.80, 221.20,
        608.60, 217.20,
        610.20, 217.20,
        611.80, 212.40,
        612.60, 210.00,
        612.60, 199.60,
        613.40, 193.20,
        615.80, 186.80,
        620.60, 178.00,
        623.80, 169.20,
        625.40, 164.40,
        627.00, 158.80,
        627.00, 149.20,
        625.40, 143.60,
        614.20, 117.20,
        606.20, 102.00,
        604.60, 102.00,
        600.60, 107.60,
        591.00, 114.00,
        582.20, 121.20,
        577.40, 124.40
);

public static Polygon latsRightBack = new Polygon(
        661.40, 101.20,
        657.40, 106.80,
        655.00, 113.20,
        651.80, 122.80,
        641.40, 146.80,
        639.80, 153.20,
        639.80, 158.00,
        641.40, 163.60,
        643.80, 170.80,
        647.80, 179.60,
        651.00, 187.60,
        652.60, 191.60,
        655.00, 195.60,
        655.00, 201.20,
        655.00, 210.80,
        655.00, 216.40,
        657.40, 218.80,
        665.40, 222.00,
        672.60, 228.40,
        676.60, 230.80,
        679.00, 234.00,
        678.20, 229.20,
        675.80, 218.00,
        674.20, 200.40,
        675.80, 188.40,
        676.60, 178.00,
        679.80, 171.60,
        679.00, 174.80,
        681.40, 170.00,
        684.60, 163.60,
        685.40, 157.20,
        689.40, 147.60,
        687.80, 144.40,
        688.60, 138.80,
        691.00, 130.80,
        691.00, 126.00,
        688.60, 123.60,
        680.60, 118.00,
        674.20, 111.60,
        668.60, 106.80,
        662.20, 101.20,
        660.60, 104.40
);

public static Polygon back = new Polygon(
        626.20, 149.20,
        627.00, 154.00,
        627.00, 158.80,
        625.40, 165.20,
        622.20, 173.20,
        619.00, 181.20,
        616.60, 185.20,
        614.20, 191.60,
        612.60, 195.60,
        612.60, 198.80,
        612.60, 203.60,
        613.40, 209.20,
        612.60, 213.20,
        609.40, 217.20,
        608.60, 219.60,
        613.40, 218.80,
        619.80, 218.00,
        623.00, 219.60,
        626.20, 221.20,
        627.80, 222.80,
        631.00, 226.80,
        632.60, 230.80,
        631.00, 226.00,
        632.60, 230.80,
        633.40, 230.80,
        635.00, 227.60,
        637.40, 223.60,
        642.20, 220.40,
        646.20, 218.80,
        650.20, 217.20,
        653.40, 218.00,
        655.00, 218.80,
        656.60, 218.80,
        657.40, 218.80,
        655.80, 217.20,
        655.00, 216.40,
        654.20, 214.00,
        654.20, 211.60,
        654.20, 206.00,
        655.00, 199.60,
        655.00, 195.60,
        654.20, 193.20,
        651.80, 187.60,
        647.00, 179.60,
        644.60, 172.40,
        642.20, 165.20,
        640.60, 162.00,
        640.60, 156.40,
        639.80, 150.80,
        639.00, 154.80,
        637.40, 155.60,
        636.60, 157.20,
        634.20, 159.60,
        632.60, 161.20,
        631.80, 160.40,
        630.20, 158.00,
        628.60, 154.00,
        627.00, 151.60
);

public static Polygon glutes = new Polygon(
        633.40, 231.60,
        631.80, 226.80,
        629.40, 223.60,
        626.20, 220.40,
        618.20, 218.00,
        611.80, 218.00,
        607.00, 218.80,
        603.80, 222.00,
        600.60, 223.60,
        598.20, 228.40,
        595.80, 234.80,
        595.80, 237.20,
        595.00, 239.60,
        593.40, 245.20,
        591.80, 249.20,
        591.00, 254.80,
        591.80, 261.20,
        594.20, 267.60,
        596.60, 270.80,
        599.80, 273.20,
        606.20, 275.60,
        615.00, 276.40,
        619.80, 277.20,
        623.80, 277.20,
        627.80, 274.80,
        631.00, 272.40,
        635.00, 267.60,
        634.20, 267.60,
        633.40, 267.60,
        635.00, 270.80,
        639.00, 274.80,
        644.60, 278.00,
        654.20, 277.20,
        660.60, 275.60,
        665.40, 274.00,
        670.20, 270.80,
        672.60, 267.60,
        675.00, 262.00,
        675.00, 256.40,
        675.80, 251.60,
        673.40, 244.40,
        671.00, 239.60,
        671.00, 234.80,
        669.40, 230.80,
        667.80, 228.40,
        665.40, 224.40,
        664.60, 222.00,
        659.80, 220.40,
        654.20, 218.00,
        650.20, 218.00,
        645.40, 218.80,
        640.60, 222.00,
        637.40, 223.60,
        636.60, 226.80,
        635.80, 228.40,
        632.60, 231.60
);

public static Polygon hamstringLeftBack = new Polygon(
        600.60, 223.60,
        597.40, 226.00,
        595.00, 227.60,
        592.60, 230.00,
        587.80, 234.80,
        587.80, 237.20,
        587.80, 242.00,
        587.00, 246.00,
        584.60, 251.60,
        582.20, 261.20,
        580.60, 271.60,
        580.60, 283.60,
        579.80, 283.60,
        578.20, 295.60,
        578.20, 304.40,
        578.20, 313.20,
        578.20, 321.20,
        579.00, 330.00,
        581.40, 342.00,
        582.20, 347.60,
        583.80, 354.00,
        584.60, 358.00,
        586.20, 361.20,
        588.60, 362.80,
        592.60, 362.80,
        592.60, 359.60,
        595.80, 354.80,
        597.40, 350.80,
        598.20, 347.60,
        599.80, 347.60,
        600.60, 353.20,
        599.80, 360.40,
        601.40, 365.20,
        603.80, 368.40,
        606.20, 368.40,
        609.40, 370.00,
        611.00, 367.60,
        611.80, 365.20,
        615.00, 358.80,
        616.60, 354.80,
        617.40, 344.40,
        619.00, 338.00,
        620.60, 331.60,
        623.00, 325.20,
        624.60, 316.40,
        627.80, 306.80,
        631.00, 294.80,
        631.80, 287.60,
        631.80, 279.60,
        632.60, 273.20,
        632.60, 271.60,
        630.20, 273.20,
        627.80, 277.20,
        618.20, 277.20,
        610.20, 276.40,
        603.00, 274.80,
        598.20, 273.20,
        595.80, 270.00,
        591.80, 264.40,
        591.80, 260.40,
        591.80, 256.40,
        591.80, 250.80,
        593.40, 245.20,
        596.60, 240.40,
        595.80, 240.40,
        597.40, 234.80,
        598.20, 230.80,
        599.00, 226.00,
        601.40, 223.60
);

public static Polygon hamstringRightBack = new Polygon(
        635.00, 272.40,
        635.00, 277.20,
        635.80, 285.20,
        636.60, 293.20,
        639.80, 305.20,
        643.00, 317.20,
        645.40, 325.20,
        646.20, 331.60,
        648.60, 342.00,
        649.40, 348.40,
        652.60, 358.80,
        654.20, 364.40,
        657.40, 367.60,
        659.00, 368.40,
        662.20, 369.20,
        664.60, 365.20,
        667.00, 361.20,
        667.00, 351.60,
        667.00, 347.60,
        669.40, 348.40,
        671.80, 353.20,
        672.60, 357.20,
        675.00, 360.40,
        676.60, 362.00,
        678.20, 362.00,
        681.40, 359.60,
        683.80, 352.40,
        685.40, 345.20,
        687.00, 340.40,
        687.80, 334.80,
        688.60, 330.80,
        688.60, 324.40,
        689.40, 317.20,
        691.00, 307.60,
        689.40, 297.20,
        687.80, 283.60,
        687.00, 274.00,
        686.20, 262.80,
        683.80, 258.00,
        681.40, 252.40,
        681.40, 246.00,
        679.80, 244.40,
        679.00, 239.60,
        679.00, 236.40,
        677.40, 232.40,
        674.20, 229.20,
        671.80, 227.60,
        669.40, 226.00,
        667.80, 225.20,
        666.20, 224.40,
        667.80, 227.60,
        670.20, 232.40,
        671.80, 238.00,
        674.20, 244.40,
        675.00, 252.40,
        675.00, 257.20,
        673.40, 263.60,
        671.00, 267.60,
        667.80, 270.80,
        664.60, 273.20,
        662.20, 275.60,
        658.20, 275.60,
        653.40, 277.20,
        649.40, 276.40,
        645.40, 276.40,
        642.20, 276.40,
        639.00, 275.60,
        635.80, 273.20,
        635.00, 271.60,
        634.20, 269.20,
        633.40, 270.80,
        635.00, 274.80
);

public static Polygon calfLeftBack = new Polygon(
        575.80, 383.60,
        575.80, 386.80,
        574.20, 392.40,
        573.40, 398.80,
        572.60, 407.60,
        572.60, 414.00,
        572.60, 422.00,
        572.60, 426.00,
        575.00, 429.20,
        575.80, 433.20,
        578.20, 434.80,
        581.40, 434.80,
        583.80, 434.00,
        586.20, 430.00,
        588.60, 426.00,
        589.40, 424.40,
        591.00, 422.00,
        592.60, 428.40,
        592.60, 431.60,
        596.60, 435.60,
        599.80, 436.40,
        602.20, 436.40,
        603.80, 433.20,
        606.20, 430.80,
        607.00, 427.60,
        608.60, 424.40,
        608.60, 422.00,
        608.60, 414.80,
        607.80, 407.60,
        607.00, 400.40,
        606.20, 394.80,
        603.80, 392.40,
        599.80, 391.60,
        596.60, 391.60,
        596.60, 391.60,
        595.00, 393.20,
        592.60, 393.20,
        589.40, 391.60,
        584.60, 386.80,
        579.80, 385.20,
        579.00, 385.20,
        577.40, 385.20
);

public static Polygon calfRightBack = new Polygon(
        660.60, 395.60,
        659.80, 403.60,
        659.80, 407.60,
        659.80, 414.80,
        657.40, 418.80,
        659.80, 425.20,
        662.20, 430.00,
        663.00, 434.00,
        665.40, 434.80,
        667.80, 436.40,
        672.60, 435.60,
        673.40, 432.40,
        674.20, 430.80,
        674.20, 426.80,
        675.80, 423.60,
        676.60, 422.80,
        679.80, 426.00,
        683.80, 432.40,
        687.00, 434.00,
        689.40, 434.00,
        691.80, 430.80,
        693.40, 425.20,
        695.00, 416.40,
        695.80, 411.60,
        695.80, 404.40,
        695.00, 399.60,
        693.40, 396.40,
        692.60, 393.20,
        691.80, 389.20,
        690.20, 386.80,
        689.40, 384.40,
        686.20, 384.40,
        683.00, 386.80,
        681.40, 388.40,
        679.00, 390.80,
        676.60, 392.40,
        672.60, 392.40,
        670.20, 392.40,
        667.00, 391.60,
        664.60, 391.60,
        662.20, 394.80,
        660.60, 396.40,
        659.80, 398.00,
        659.80, 402.00
);

public static Polygon tricepLeftBack = new Polygon(
        578.20, 122.80,
        575.00, 124.40,
        568.60, 126.00,
        566.20, 125.20,
        560.60, 125.20,
        559.00, 126.80,
        557.40, 127.60,
        551.80, 133.20,
        549.40, 136.40,
        547.00, 139.60,
        544.60, 143.60,
        542.20, 150.80,
        539.80, 155.60,
        537.40, 159.60,
        536.60, 165.20,
        536.60, 168.40,
        538.20, 168.40,
        542.20, 167.60,
        545.40, 167.60,
        547.00, 170.00,
        547.80, 174.00,
        548.60, 177.20,
        550.20, 178.00,
        551.80, 178.00,
        555.80, 177.20,
        559.00, 174.00,
        562.20, 168.40,
        563.80, 168.40,
        567.00, 165.20,
        572.60, 156.40,
        576.60, 149.20,
        579.00, 147.60,
        579.00, 142.80,
        578.20, 136.40,
        576.60, 130.80,
        576.60, 125.20,
        576.60, 123.60,
        578.20, 122.80,
        574.20, 125.20,
        569.40, 126.00,
        566.20, 126.00
);

public static Polygon tricepRightBack = new Polygon(
        690.20, 122.80,
        691.00, 126.80,
        691.00, 130.80,
        689.40, 136.40,
        687.80, 138.80,
        688.60, 142.00,
        687.80, 145.20,
        689.40, 149.20,
        692.60, 153.20,
        696.60, 158.80,
        700.60, 165.20,
        703.00, 167.60,
        706.20, 173.20,
        710.20, 174.80,
        711.00, 177.20,
        715.00, 179.60,
        716.60, 179.60,
        718.20, 178.80,
        719.00, 174.00,
        719.80, 170.80,
        720.60, 168.40,
        722.20, 167.60,
        725.40, 167.60,
        728.60, 169.20,
        731.00, 166.00,
        731.00, 162.00,
        727.80, 157.20,
        725.40, 152.40,
        723.80, 148.40,
        723.00, 146.00,
        720.60, 141.20,
        718.20, 136.40,
        712.60, 129.20,
        710.20, 128.40,
        707.80, 126.80,
        703.80, 126.00,
        699.00, 126.00,
        694.20, 125.20,
        691.80, 124.40,
        690.20, 124.40
        );

public static Polygon forearmLeftBack = new Polygon(
        535.80, 165.20,
        534.20, 166.80,
        528.60, 171.60,
        526.20, 174.80,
        523.80, 178.00,
        521.40, 183.60,
        519.00, 187.60,
        516.60, 192.40,
        515.00, 194.80,
        513.40, 198.80,
        510.20, 204.40,
        508.60, 211.60,
        503.00, 230.80,
        503.00, 230.80,
        503.80, 233.20,
        504.60, 237.20,
        507.80, 237.20,
        510.20, 237.20,
        512.60, 237.20,
        515.00, 237.20,
        516.60, 230.80,
        520.60, 226.00,
        528.60, 218.80,
        530.20, 215.60,
        532.60, 213.20,
        534.20, 212.40,
        535.80, 210.00,
        541.40, 202.80,
        546.20, 193.20,
        550.20, 184.40,
        557.40, 178.00,
        555.00, 178.00,
        551.80, 178.00,
        549.40, 178.00,
        547.80, 178.00,
        548.60, 174.80,
        547.80, 174.00,
        547.80, 172.40,
        547.00, 170.00,
        546.20, 167.60,
        542.20, 168.40,
        538.20, 168.40,
        537.40, 168.40,
        535.80, 167.60,
        535.80, 166.00
);

public static Polygon forearmRightBack = new Polygon(
        711.00, 178.80,
        714.20, 182.80,
        718.20, 187.60,
        721.40, 194.00,
        726.20, 201.20,
        732.60, 209.20,
        737.40, 216.40,
        742.20, 223.60,
        747.80, 227.60,
        752.60, 233.20,
        752.60, 235.60,
        752.60, 237.20,
        756.60, 237.20,
        760.60, 237.20,
        762.20, 236.40,
        763.80, 234.00,
        766.20, 232.40,
        763.00, 224.40,
        759.00, 218.00,
        759.80, 214.80,
        756.60, 204.40,
        753.40, 198.00,
        751.80, 191.60,
        747.80, 184.40,
        743.80, 179.60,
        737.40, 174.80,
        737.40, 173.20,
        735.80, 170.00,
        731.00, 165.20,
        731.00, 167.60,
        727.80, 168.40,
        725.40, 168.40,
        722.20, 168.40,
        720.60, 168.40,
        720.60, 171.60,
        720.60, 175.60,
        719.00, 178.00,
        717.40, 178.00,
        715.00, 178.00,
        713.40, 178.00,
        712.60, 178.00,
        711.00, 178.00
        );

    public static List<Polygon> getAllMusclesMan(){
        return Arrays.asList(trapsLeftFront,trapsRightFront,chestFront,shoulderLeftFront,shoulderRightFront,abdominalsFront,obliqueLeftFront,obliqueRightFront,bicepsLeftFront,bicepsRightFront,forearmLeftFront,forearmRightFront,quadricepsLeftFront,quadricepsRightFront,calfLeftFront,calfRightFront,
                trapsUpBack,trapsDownBack,shoulderLeftBack,shoulderRightBack,latsLeftBack,latsRightBack,back,glutes,hamstringLeftBack,hamstringRightBack,calfLeftBack,calfRightBack,tricepLeftBack,tricepRightBack,forearmLeftBack,forearmRightBack);
    }


}
