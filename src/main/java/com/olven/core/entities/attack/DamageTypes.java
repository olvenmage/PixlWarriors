package com.olven.core.entities.attack;

import com.olven.core.items.armor.ArmorTypes;

public abstract class DamageTypes {
    public static DamageClass slashing = new DamageClass(ArmorTypes.light, ArmorTypes.heavy);
    public static DamageClass piercing = new DamageClass(ArmorTypes.heavy, ArmorTypes.light);
    public static DamageClass bludgeoning = new DamageClass(ArmorTypes.heavy, ArmorTypes.light);
    public static DamageClass fire = new DamageClass(ArmorTypes.heavy, ArmorTypes.light);
    public static DamageClass cold = new DamageClass(ArmorTypes.heavy, ArmorTypes.light);
    public static DamageClass poison = new DamageClass(ArmorTypes.heavy, ArmorTypes.light);
    public static DamageClass psychic = new DamageClass(ArmorTypes.heavy, ArmorTypes.light);
    public static DamageClass lightning = new DamageClass(ArmorTypes.heavy, ArmorTypes.light);

}
