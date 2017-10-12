package newmod.common.entities;

import javax.annotation.Nonnull;
import javax.swing.Renderer;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class Render_Bee extends RenderLiving<Bee_Entity>
  {
    private ResourceLocation mobTexture = new ResourceLocation("newmod:textures/entity/bee2.png");
    public static final Factory FACTORY = new Factory();

    public Render_Bee(RenderManager rendermanagerIn)
      {
        super(rendermanagerIn, new Bee_Model(), 0.5F);
      }
    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull Bee_Entity entity)
      {
        return mobTexture;
      }
    public static class Factory implements IRenderFactory<Bee_Entity>
      {
        @Override
        public Render<? super Bee_Entity> createRenderFor(RenderManager manager)
          {
            return new Render_Bee(manager);
          }
     }
  }