package satisfyu.candlelight.client.render.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import de.cristelknight.doapi.block.entity.StorageBlockEntity;
import de.cristelknight.doapi.client.render.block.storage.StorageTypeRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import satisfyu.vinery.client.ClientUtil;
@Environment(EnvType.CLIENT)
public class CakeStandRenderer implements StorageTypeRenderer {
    @Override
    public void render(StorageBlockEntity entity, PoseStack matrices, MultiBufferSource vertexConsumers, NonNullList<ItemStack> itemStacks) {
        for (int i = 0; i < itemStacks.size(); i++) {
            ItemStack stack = itemStacks.get(i);
            if(!stack.isEmpty()) {
                matrices.pushPose();

                if (stack.getItem() instanceof BlockItem blockItem) {
                    matrices.scale(0.65f, 0.65f, 0.65f);
                    matrices.translate(-0.5f, 0.8f, -0.5);
                    ClientUtil.renderBlockFromItem(blockItem, matrices, vertexConsumers, entity);
                } else {
                    matrices.scale(0.4f, 0.4f, 0.4f);
                    if(i == 0) matrices.translate(-0.4f, 1.3f, 0.4f);
                    else if(i == 1) matrices.translate(-0.2f, 1.3f, -0.4f);
                    else matrices.translate(0.4f, 1.3f, 0.2f);
                    matrices.mulPose(Vector3f.XP.rotationDegrees(90f));
                    ClientUtil.renderItem(stack, matrices, vertexConsumers, entity);
                }
                matrices.popPose();
            }
        }
    }
}
