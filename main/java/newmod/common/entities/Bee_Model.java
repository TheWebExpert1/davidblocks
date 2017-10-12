package newmod.common.entities;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class Bee_Model extends ModelBase
  {
    //fields
    ModelRenderer tail;
    ModelRenderer tailHook;
    ModelRenderer abdomen1;
    ModelRenderer abdomen2;
    ModelRenderer mid;
    ModelRenderer thorax;
    ModelRenderer head;
    ModelRenderer frontLeftLeg;
    ModelRenderer midLeftLeg;
    ModelRenderer backLeftLeg;
    ModelRenderer frontRightLeg;
    ModelRenderer midRightLeg;
    ModelRenderer backRightLeg;
    ModelRenderer rightAntenna;
    ModelRenderer leftAntenna;
    ModelRenderer rightWing;
    ModelRenderer leftWing;
  
    public Bee_Model()
      {
        textureWidth = 64;
        textureHeight = 32;
    
        tail = new ModelRenderer(this, 0, 29);
        tail.addBox(0F, 0F, 0F, 2, 1, 2);
        tail.setRotationPoint(-1F, 4F, 5F);
        tail.setTextureSize(64, 32);
        tail.mirror = true;
        setRotation(tail, 0F, 0F, 0F);
        tailHook = new ModelRenderer(this, 11, 30);
        tailHook.addBox(0F, 0F, 0F, 2, 1, 1);
        tailHook.setRotationPoint(-1F, 5F, 7F);
        tailHook.setTextureSize(64, 32);
        tailHook.mirror = true;
        setRotation(tailHook, 0F, 0F, 0F);
        abdomen1 = new ModelRenderer(this, 20, 27);
        abdomen1.addBox(0F, 0F, 0F, 4, 3, 2);
        abdomen1.setRotationPoint(-2F, 3F, 3F);
        abdomen1.setTextureSize(64, 32);
        abdomen1.mirror = true;
        setRotation(abdomen1, 0F, 0F, 0F);
        abdomen2 = new ModelRenderer(this, 33, 23);
        abdomen2.addBox(0F, 0F, 0F, 6, 5, 4);
        abdomen2.setRotationPoint(-3F, 2F, -1F);
        abdomen2.setTextureSize(64, 32);
        abdomen2.mirror = true;
        setRotation(abdomen2, 0F, 0F, 0F);
        mid = new ModelRenderer(this, 54, 28);
        mid.addBox(0F, 0F, 0F, 4, 3, 1);
        mid.setRotationPoint(-2F, 3F, -2F);
        mid.setTextureSize(64, 32);
        mid.mirror = true;
        setRotation(mid, 0F, 0F, 0F);
        thorax = new ModelRenderer(this, 0, 0);
        thorax.addBox(0F, 0F, 0F, 6, 5, 6);
        thorax.setRotationPoint(-3F, 2F, -8F);
        thorax.setTextureSize(64, 32);
        thorax.mirror = true;
        setRotation(thorax, 0F, 0F, 0F);
        head = new ModelRenderer(this, 32, 0);
        head.addBox(0F, 0F, 0F, 4, 3, 1);
        head.setRotationPoint(-2F, 3F, -9F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        frontLeftLeg = new ModelRenderer(this, 0, 12);
        frontLeftLeg.addBox(0F, 0F, 0F, 1, 5, 1);
        frontLeftLeg.setRotationPoint(3F, 4F, -6F);
        frontLeftLeg.setTextureSize(64, 32);
        frontLeftLeg.mirror = true;
        setRotation(frontLeftLeg, 0F, 0F, 0F);
        midLeftLeg = new ModelRenderer(this, 0, 13);
        midLeftLeg.addBox(0F, 0F, 0F, 1, 5, 1);
        midLeftLeg.setRotationPoint(3F, 4F, -3F);
        midLeftLeg.setTextureSize(64, 32);
        midLeftLeg.mirror = true;
        setRotation(midLeftLeg, 0F, 0F, 0F);
        backLeftLeg = new ModelRenderer(this, 0, 12);
        backLeftLeg.addBox(0F, 0F, 0F, 1, 5, 1);
        backLeftLeg.setRotationPoint(3F, 4F, 1F);
        backLeftLeg.setTextureSize(64, 32);
        backLeftLeg.mirror = true;
        setRotation(backLeftLeg, 0F, 0F, 0F);
        frontRightLeg = new ModelRenderer(this, 0, 12);
        frontRightLeg.addBox(0F, 0F, 0F, 1, 5, 1);
        frontRightLeg.setRotationPoint(-4F, 4F, -6F);
        frontRightLeg.setTextureSize(64, 32);
        frontRightLeg.mirror = true;
        setRotation(frontRightLeg, 0F, 0F, 0F);
        midRightLeg = new ModelRenderer(this, 0, 12);
        midRightLeg.addBox(0F, 0F, 0F, 1, 5, 1);
        midRightLeg.setRotationPoint(-4F, 4F, -3F);
        midRightLeg.setTextureSize(64, 32);
        midRightLeg.mirror = true;
        setRotation(midRightLeg, 0F, 0F, 0F);
        backRightLeg = new ModelRenderer(this, 0, 12);
        backRightLeg.addBox(0F, 0F, 0F, 1, 5, 1);
        backRightLeg.setRotationPoint(-4F, 4F, 1F);
        backRightLeg.setTextureSize(64, 32);
        backRightLeg.mirror = true;
        setRotation(backRightLeg, 0F, 0F, 0F);
        rightAntenna = new ModelRenderer(this, 0, 12);
        rightAntenna.addBox(0F, 0F, 0F, 1, 2, 1);
        rightAntenna.setRotationPoint(-3F, 1F, -9F);
        rightAntenna.setTextureSize(64, 32);
        rightAntenna.mirror = true;
        setRotation(rightAntenna, 0F, 0F, 0F);
        leftAntenna = new ModelRenderer(this, 0, 12);
        leftAntenna.addBox(0F, 0F, 0F, 1, 2, 1);
        leftAntenna.setRotationPoint(2F, 1F, -9F);
        leftAntenna.setTextureSize(64, 32);
        leftAntenna.mirror = true;
        setRotation(leftAntenna, 0F, 0F, 0F);
        rightWing = new ModelRenderer(this, 5, 12);
        rightWing.addBox(-4F, 0F, 0F, 4, 1, 6);
        rightWing.setRotationPoint(-2F, 1F, -6F);
        rightWing.setTextureSize(64, 32);
        rightWing.mirror = true;
        setRotation(rightWing, 0F, 0F, 0F);
        leftWing = new ModelRenderer(this, 26, 12);
        leftWing.addBox(0F, 0F, 0F, 4, 1, 6);
        leftWing.setRotationPoint(2F, 1F, -6F);
        leftWing.setTextureSize(64, 32);
        leftWing.mirror = true;
        setRotation(leftWing, 0F, 0F, 0F);
      }  
    public void render(Entity entity, float f1, float f2, float f3, float f4, float f5, float f6)
      {
        super.render(entity, f1, f2, f3, f4, f5, f6);
        setRotationAngles(f1, f2, f3, f4, f5, f6, entity);
        tail.render(f6);     tailHook.render(f6);
        abdomen1.render(f6); abdomen2.render(f6);
        mid.render(f6); thorax.render(f6); head.render(f6);
        frontLeftLeg.render(f6);  midLeftLeg.render(f6);  backLeftLeg.render(f6);
        frontRightLeg.render(f6); midRightLeg.render(f6); backRightLeg.render(f6);
        rightAntenna.render(f6);  leftAntenna.render(f6);
        leftWing.render(f6);  rightWing.render(f6); 
      }  
    private void setRotation(ModelRenderer model, float x, float y, float z)
      {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
      }  
    public void setRotationAngles(float f1, float f2, float f3, float f4, float f5, float f6, Entity entity)
      {
    	//f1: time; f2: movement speed; f3: ??  f4: clockwise y; f5: clockwise x; f6: ??
        super.setRotationAngles(f1, f2, f3, f4, f5, f6, entity);
        if (entity.ticksExisted%20==0 && f2 <= 0.1F)
          {        
            this.leftWing.rotateAngleX = MathHelper.cos(f1 * 1.6662F) * 5.4F * f2;
            this.rightWing.rotateAngleX = MathHelper.cos(f1 * 1.6662F + (float)Math.PI) * -5.4F * f2;
          }
        this.frontLeftLeg.rotateAngleX = MathHelper.cos(f1 * 1.6662F + (float)Math.PI) * -5.4F * f2;
        this.midLeftLeg.rotateAngleX = MathHelper.cos(f1 * 1.6662F + (float)Math.PI) * -5.4F * f2;
        this.backLeftLeg.rotateAngleX = MathHelper.cos(f1 * 1.6662F + (float)Math.PI) * -5.4F * f2;
        this.frontRightLeg.rotateAngleX = MathHelper.cos(f1 * 1.6662F + (float)Math.PI) * -5.4F * f2;
        this.midRightLeg.rotateAngleX = MathHelper.cos(f1 * 1.6662F + (float)Math.PI) * -5.4F * f2;
        this.backRightLeg.rotateAngleX = MathHelper.cos(f1 * 1.6662F + (float)Math.PI) * -5.4F * f2;
      }
  }