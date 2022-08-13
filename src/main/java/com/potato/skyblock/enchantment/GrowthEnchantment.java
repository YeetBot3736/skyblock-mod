package com.potato.skyblock.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.text.Text;

import static net.minecraft.entity.EquipmentSlot.*;

public class GrowthEnchantment extends Enchantment {

    public GrowthEnchantment() {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.ARMOR, new EquipmentSlot[]{HEAD,CHEST,LEGS,FEET});
    }
    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLetters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(romanLetters[i]);
            }
        }
        return roman.toString();
    }
    @Override
    public int getMinPower(int level){
        return -1;
    }
    @Override
    public int getMaxLevel(){
        return 7;
    }
    @Override
    public Text getName(int level) {
        return Text.of("Growth " + intToRoman(level));
    }

}
