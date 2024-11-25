package net.mcreator.advancedweaponry.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelexoskeleton<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("advanced_weaponry", "modelexoskeleton"), "main");
	public final ModelPart Helmet;
	public final ModelPart Chestplate;
	public final ModelPart RightPlate;
	public final ModelPart LeftPlate;
	public final ModelPart RightLegging;
	public final ModelPart LeftLegging;
	public final ModelPart RightBoot;
	public final ModelPart LeftBoot;

	public Modelexoskeleton(ModelPart root) {
		this.Helmet = root.getChild("Helmet");
		this.Chestplate = root.getChild("Chestplate");
		this.RightPlate = root.getChild("RightPlate");
		this.LeftPlate = root.getChild("LeftPlate");
		this.RightLegging = root.getChild("RightLegging");
		this.LeftLegging = root.getChild("LeftLegging");
		this.RightBoot = root.getChild("RightBoot");
		this.LeftBoot = root.getChild("LeftBoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Helmet = partdefinition.addOrReplaceChild("Helmet",
				CubeListBuilder.create().texOffs(18, 5).addBox(-5.0F, -5.0F, -3.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(3, 16).addBox(3.0F, -5.0F, -3.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(10, 40)
						.addBox(-3.0F, -5.0F, 4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-1.0F, -4.0F, 4.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(15, 31)
						.addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(38, 25).addBox(1.0F, -5.0F, 4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Chestplate = partdefinition.addOrReplaceChild("Chestplate",
				CubeListBuilder.create().texOffs(46, 0).addBox(-4.0F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 40).addBox(-4.0F, -1.0F, -1.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 31)
						.addBox(-5.0F, 11.0F, 0.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(24, 46).addBox(-1.0F, 0.0F, 1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 20)
						.addBox(-1.0F, 4.0F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(15, 7).addBox(-1.0F, 7.0F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 26)
						.addBox(-1.0F, 10.0F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(30, 3).addBox(-0.5F, 9.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(30, 0)
						.addBox(-0.5F, 6.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 29).addBox(-0.5F, 3.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(41, 9)
						.addBox(1.0F, 11.0F, 0.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(14, 40).addBox(1.0F, -1.0F, -1.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(45, 44)
						.addBox(1.0F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(33, 36).addBox(-5.0F, 11.0F, 0.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition RightPlate = partdefinition.addOrReplaceChild("RightPlate",
				CubeListBuilder.create().texOffs(37, 31).addBox(0.0F, -3.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(36, 41).addBox(-2.0F, -3.0F, -1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(-2.0F, -2.0F, 2.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 2).addBox(-1.5F, 3.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(15, 0)
						.addBox(-2.0F, 4.0F, 2.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 23).addBox(-4.0F, 9.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));
		PartDefinition LeftPlate = partdefinition.addOrReplaceChild("LeftPlate",
				CubeListBuilder.create().texOffs(11, 35).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(15, 15).addBox(-2.0F, 9.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 13)
						.addBox(0.0F, 4.0F, 2.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 0).addBox(0.5F, 3.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(15, 15)
						.addBox(0.0F, -2.0F, 2.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(24, 41).addBox(0.0F, -3.0F, -1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 2.0F, 0.0F));
		PartDefinition RightLegging = partdefinition.addOrReplaceChild("RightLegging",
				CubeListBuilder.create().texOffs(0, 35).addBox(-3.1F, -1.0F, 0.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(30, 9).addBox(-3.1F, 6.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(26, 31)
						.addBox(-3.1F, 4.0F, -3.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(12, 45).addBox(-3.1F, 1.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.9F, 12.0F, 0.0F));
		PartDefinition LeftLegging = partdefinition.addOrReplaceChild("LeftLegging",
				CubeListBuilder.create().texOffs(38, 20).addBox(-0.9F, -1.0F, 0.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(33, 15).addBox(-0.9F, 4.0F, -3.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(45, 39)
						.addBox(-0.9F, 1.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(44, 14).addBox(-0.9F, 6.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition RightBoot = partdefinition.addOrReplaceChild("RightBoot",
				CubeListBuilder.create().texOffs(30, 0).addBox(-3.1F, 10.0F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 45).addBox(-3.1F, 7.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.9F, 12.0F, 0.0F));
		PartDefinition LeftBoot = partdefinition.addOrReplaceChild("LeftBoot",
				CubeListBuilder.create().texOffs(0, 26).addBox(-1.9F, 10.0F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(44, 25).addBox(-0.9F, 7.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.9F, 12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Helmet.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Chestplate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightPlate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftPlate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLegging.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLegging.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Helmet.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Helmet.xRot = headPitch / (180F / (float) Math.PI);
	}
}
