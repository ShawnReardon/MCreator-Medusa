package net.mcreator.medusa.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.medusa.init.MedusaModBlocks;

import java.util.Comparator;

public class AppleArmorHelmetTickEventProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double lookX = 0;
		double lookY = 0;
		double lookZ = 0;
		lookX = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)),
				ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
		lookY = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)),
				ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
		lookZ = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)),
				ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
		if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(lookX, lookY, lookZ), 1, 1, 1), e -> true).isEmpty()) {
			if (((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(lookX, lookY, lookZ), 1, 1, 1), e -> true).stream()
					.sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(lookX, lookY, lookZ)).findFirst().orElse(null)) instanceof Cow) {
				{
					BlockPos _bp = new BlockPos((int) (((Entity) world
							.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(lookX, lookY, lookZ), 1, 1, 1), e -> true).stream()
							.sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(lookX, lookY, lookZ)).findFirst().orElse(null)).getX()),
							(int) (((Entity) world
									.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(lookX, lookY, lookZ), 1, 1, 1), e -> true).stream()
									.sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf(lookX, lookY, lookZ)).findFirst().orElse(null)).getY()),
							(int) (((Entity) world
									.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(lookX, lookY, lookZ), 1, 1, 1), e -> true).stream()
									.sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf(lookX, lookY, lookZ)).findFirst().orElse(null)).getZ()));
					BlockState _bs = MedusaModBlocks.STONE_COW.defaultBlockState();
					world.setBlock(_bp, _bs, 3);
				}
			}
			if (!((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(lookX, lookY, lookZ), 1, 1, 1), e -> true).stream()
					.sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(lookX, lookY, lookZ)).findFirst().orElse(null)).level.isClientSide())
				((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(lookX, lookY, lookZ), 1, 1, 1), e -> true).stream()
						.sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(lookX, lookY, lookZ)).findFirst().orElse(null)).discard();
		}
	}
}
