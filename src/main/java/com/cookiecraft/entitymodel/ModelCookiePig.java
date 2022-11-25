package com.cookiecraft.entitymodel;

import com.cookiecraft.entity.EntityCookiePig;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelCookiePig extends EntityModel<EntityCookiePig> {
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer leftLeg;
    private final ModelRenderer rightLeg;
    private final ModelRenderer hail;

    private void addCube(ModelRenderer modelRenderer, int texture_x, int texture_y, float x, float y, float z, float dx, float dy, float dz, float delta, boolean m){
        modelRenderer.setTextureOffset(texture_x, texture_y);
        modelRenderer.addBox(x, y, z, dx, dy, dz, delta, m);
    }

    public ModelCookiePig() {
        textureWidth = 64;
        textureHeight = 64;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        addCube(body, 0, 13, -5.0F, -11.0F, -8.0F, 10, 8, 16, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 24.0F, 0.0F);
        addCube(head, 0, 0, -4.0F, -10.0F, -14.0F, 8, 5, 6, 0.0F, false);

        leftLeg = new ModelRenderer(this);
        leftLeg.setRotationPoint(0.0F, 24.0F, 0.0F);
        addCube(leftLeg, 0, 56, 5.0F, -6.0F, -5.0F, 2, 6, 2, 0.0F, false);
        addCube(leftLeg, 0, 56, 5.0F, -6.0F, 4.0F, 2, 6, 2, 0.0F, false);

        rightLeg = new ModelRenderer(this);
        rightLeg.setRotationPoint(-12.0F, 24.0F, 0.0F);
        addCube(rightLeg, 0, 56, 5.0F, -6.0F, -5.0F, 2, 6, 2, 0.0F, false);
        addCube(rightLeg, 0, 56, 5.0F, -6.0F, 4.0F, 2, 6, 2, 0.0F, false);

        hail = new ModelRenderer(this);
        hail.setRotationPoint(0.0F, 24.0F, 0.0F);
        addCube(hail, 0, 37, -1.0F, -10.0F, 8.0F, 1, 1, 9, 0.0F, false);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        leftLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        rightLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        hail.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setRotationAngles(EntityCookiePig entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        this.head.rotateAngleX = (float)(Math.PI / 180) * headPitch;
        this.head.rotateAngleY = (float)(Math.PI / 180) * netHeadYaw;
        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount * 1.25F;
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount * 1.25F;
    }
}
