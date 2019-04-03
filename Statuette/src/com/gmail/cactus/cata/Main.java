package com.gmail.cactus.cata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	private static int i = 1;
	private static StringBuilder builder = new StringBuilder("/summon FallingSand ~ ~1 ~ ");
	private static double x, y, z;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quelle direction ?");
		String rep = sc.nextLine();
		System.out.println("Coordonées en x");
		x = sc.nextDouble();
		System.out.println("Coordonées en y");
		y = sc.nextDouble();
		System.out.println("Coordonées en z");
		z = sc.nextDouble();

		if (rep.equalsIgnoreCase("north")) {
			for (int nbr = 0; nbr < 29; nbr++) {
				builder.append("{id:\"FallingSand\",Riding:");
			}
			builder.append("{id:\"FallingSand\",");

			createArmorStand(0.4125, 0.41875, 0.5125); // 1
			createArmorStand(0.2875, 0.41875, 0.5125); // 2
			createArmorStand(0.4125, 0.41875, 0.6375); // 3
			createArmorStand(0.2875, 0.41875, 0.6375); // 4
			createArmorStand(0.4125, 0.29375, 0.5125); // 5
			createArmorStand(0.2875, 0.29375, 0.5125); // 6
			createArmorStand(0.4125, 0.29375, 0.6375); // 7
			createArmorStand(0.2875, 0.29375, 0.6375); // 8

			createArmorStand(0.5375, 0.16875, 0.575); // 9
			createArmorStand(0.4125, 0.16875, 0.575); // 10
			createArmorStand(0.2875, 0.16875, 0.575); // 11
			createArmorStand(0.1625, 0.16875, 0.575); // 12
			createArmorStand(0.5375, 0.04375, 0.575); // 13
			createArmorStand(0.4125, 0.04375, 0.575); // 14
			createArmorStand(0.2875, 0.04375, 0.575); // 15
			createArmorStand(0.1625, 0.04375, 0.575); // 16
			createArmorStand(0.5375, -0.08125, 0.575); // 17
			createArmorStand(0.4125, -0.08125, 0.575); // 18
			createArmorStand(0.2875, -0.08125, 0.575); // 19
			createArmorStand(0.1625, -0.08125, 0.575); // 20

			createArmorStand(0.4125, -0.20625, 0.575); // 21
			createArmorStand(0.2875, -0.20625, 0.575); // 22
			createArmorStand(0.4125, -0.33125, 0.575); // 23
			createArmorStand(0.2875, -0.33125, 0.575); // 24
			createArmorStand(0.4125, -0.46, 0.575); // 25
			createArmorStand(0.2875, -0.46, 0.575); // 26

			builder.append(
					"TileEntityData:{Command:\"fill ~-1 ~ ~ ~-1 ~-26 ~ redstone_block\"},TileID:137,Time:1b},TileID:152,Time:1b},TileEntityData:{Command:\"fill ~ ~1 ~ ~-1 ~-29 ~ air\"},TileID:137,Time:1b},TileID:152,Time:1b}");
			System.out.println("Pour un armorstand avec les coordonées de pose en x : " + x + " ,y : " + y + " ,z : "
					+ z + " ,il y aura la commande suivante : \n" + builder);

		}

		sc.close();
	}

	private static void createArmorStand(double d, double e, double f) {

		builder.append("TileEntityData:{Command:\"/summon ArmorStand " + (x + d) + " " + (y + e) + " " + (z + f)
				+ " {Pose:{RightArm:[340f]},Rotation:[225f],NoBasePlate:1b,Equipment:[{id:\\\"minecraft:skull\\\",Count:1,Damage:3,tag:{SkullOwner:{Id:\\\"");
		readFile("D:/Adam/Programming/Java/Eclipse/workspace/Other/Statuette/src/UUID.txt", i);
		builder.append("\\\",Properties:{textures:[{Value:\\\"");
		readFile("D:/Adam/Programming/Java/Eclipse/workspace/Other/Statuette/src/Textures.txt", i);
		builder.append(
				"\\\"}]}}}}],NoGravity:1,Invisible:1,Small:1b,DisabledSlots:2039583,CustomNameVisible:0b,CustomName:\\\""
						+ i + "\\\"}\"},TileID:137,Time:1b},");
		i++;

	}

	private static void readFile(String pathToFile, int i) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(pathToFile)));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith(i + ":")) {
					builder.append(i < 10 ? line.substring(2) : line.substring(3));
				}

			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

}
