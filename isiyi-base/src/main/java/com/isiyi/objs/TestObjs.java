package com.isiyi.objs;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestObjs {

    @Test
    public void test1(){

        int i = 0;
        String str = "0";
        swap(i);
        System.out.println(i);
        swap(str);
        System.out.println(str);

        List<String> list = new ArrayList<>();
        swap(list);
        System.out.println(list.size());
        System.out.println(list);

    }

    private void swap(int i){
        i = 2;
    }

    private void swap(String i){
        i = "2";
    }

    private void swap(List<String> list){
        list.add("2");
    }

    @Test
    public void testShard(){
        getCustomerSharding("9000000028");
    }

    public static void getCustomerSharding(String value) {
        //String value = "9000000021";
        Long delivery = Long.parseLong(value) % (4 * 8);
        String suffix = delivery.toString();
        if (delivery < 10) {
            suffix = "0" + delivery.toString();
        }
        System.out.println(suffix);
    }

    @Test
    public void testFilterRealtime(){
        ArrayList<String> list = tableList();
        list.stream().filter(l -> l.endsWith("_r")).forEach(System.out::println);
    }

    public static ArrayList<String> tableList(){
        ArrayList<String> list = Lists.newArrayList(
                "dwb_authdb_employee_t",
                "dwb_boh_tgoodsprice_t",
                "dwb_expressdb_delivery_meal_prepare_time_d",
                "dwb_expressdb_delivery_order_d",
                "dwb_expressdb_delivery_period_freight_d",
                "dwb_expressdb_delivery_shipping_distance_d",
                "dwb_expressdb_delivery_time_d",
                "dwb_expressdb_distribution_rules_call_config_d",
                "dwb_expressdb_distribution_rules_d",
                "dwb_expressdb_distribution_rules_logistics_company_d",
                "dwb_expressdb_distribution_rules_shop_d",
                "dwb_expressdb_logistics_company_d",
                "dwb_fooddb_food_category_t",
                "dwb_fooddb_food_label_t",
                "dwb_fooddb_food_t",
                "dwb_fooddb_km_food_t",
                "dwb_fooddb_made_food_t",
                "dwb_fooddb_made_t",
                "dwb_fooddb_operate_category_t",
                "dwb_fooddb_shop_food_t",
                "dwb_fooddb_shop_made_t",
                "dwb_memberdb_card_level_t",
                "dwb_memberdb_customer_card_r",
                "dwb_memberdb_customer_card_t",
                "dwb_memberdb_customer_growth_t",
                "dwb_memberdb_customer_label_bind_d",
                "dwb_memberdb_customer_open_relation_t",
                "dwb_memberdb_customer_point_t",
                "dwb_memberdb_customer_r",
                "dwb_memberdb_customer_t",
                "dwb_memberdb_customer_wallet_t",
                "dwb_memberdb_label_t",
                "dwb_oa_datapermissions_all_new_t",
                "dwb_operation_managedb_audit_check_basic_t",
                "dwb_operation_managedb_audit_check_category_t",
                "dwb_operation_managedb_audit_check_task_option_t",
                "dwb_operation_managedb_audit_report_t",
                "dwb_operation_managedb_audit_task_t",
                "dwb_operation_managedb_clean_plan_content_t",
                "dwb_operation_managedb_duty_check_node_t",
                "dwb_operation_managedb_duty_task_d",
                "dwb_operation_managedb_duty_task_node_d",
                "dwb_operation_managedb_responsible_group_t",
                "dwb_operation_managedb_responsible_staff_score_d",
                "dwb_operation_managedb_responsible_staff_t",
                "dwb_operation_managedb_shop_clean_log_d",
                "dwb_orderdb_canteen_order_return_d",
                "dwb_orderdb_canteen_order_return_r",
                "dwb_orderdb_cloud_pos_shop_t",
                "dwb_orderdb_mall_order_express_item_d",
                "dwb_orderdb_mall_order_express_item_r",
                "dwb_orderdb_mall_order_express_no_d",
                "dwb_orderdb_mall_order_express_no_r",
                "dwb_orderdb_mall_order_item_coupon_d",
                "dwb_orderdb_mall_order_item_coupon_r",
                "dwb_orderdb_mall_order_item_d",
                "dwb_orderdb_mall_order_item_r",
                "dwb_orderdb_mall_order_logistics_d",
                "dwb_orderdb_mall_order_logistics_r",
                "dwb_orderdb_mall_order_promotion_d",
                "dwb_orderdb_mall_order_promotion_r",
                "dwb_orderdb_mall_order_sale_d",
                "dwb_orderdb_mall_order_sale_r",
                "dwb_orderdb_mall_reserve_order_d",
                "dwb_orderdb_mall_reserve_order_r",
                "dwb_orderdb_mall_return_item_coupon_d",
                "dwb_orderdb_mall_return_item_coupon_r",
                "dwb_orderdb_mall_return_item_d",
                "dwb_orderdb_mall_return_item_r",
                "dwb_orderdb_mall_return_logistics_d",
                "dwb_orderdb_mall_return_logistics_r",
                "dwb_orderdb_mall_return_order_d",
                "dwb_orderdb_mall_return_order_r",
                "dwb_orderdb_mall_return_payment_d",
                "dwb_orderdb_mall_return_payment_r",
                "dwb_orderdb_mall_return_promotion_d",
                "dwb_orderdb_mall_return_promotion_r",
                "dwb_orderdb_order_delivery_d",
                "dwb_orderdb_order_food_d",
                "dwb_orderdb_order_food_grade_d",
                "dwb_orderdb_order_food_grade_r",
                "dwb_orderdb_order_food_made_d",
                "dwb_orderdb_order_food_made_r",
                "dwb_orderdb_order_food_r",
                "dwb_orderdb_order_payment_d",
                "dwb_orderdb_order_payment_r",
                "dwb_orderdb_order_promotion_d",
                "dwb_orderdb_order_promotion_r",
                "dwb_orderdb_order_return_food_d",
                "dwb_orderdb_order_return_food_r",
                "dwb_orderdb_order_return_payment_d",
                "dwb_orderdb_order_return_payment_r",
                "dwb_orderdb_order_return_promotion_d",
                "dwb_orderdb_order_return_promotion_r",
                "dwb_orderdb_order_return_summary_d",
                "dwb_orderdb_order_sale_d",
                "dwb_orderdb_order_sale_index_d",
                "dwb_orderdb_order_sale_index_r",
                "dwb_orderdb_order_sale_r",
                "dwb_orderdb_order_sale_summary_d",
                "dwb_orderdb_order_status_trace_d",
                "dwb_orderdb_order_sub_d",
                "dwb_orderdb_order_sub_r",
                "dwb_orderdb_takeout_order_return_d",
                "dwb_orderdb_takeout_order_return_r",
                "dwb_orderdb_takeout_order_sale_d",
                "dwb_orderdb_takeout_order_sale_r",
                "dwb_paymentdb_pay_mode_t",
                "dwb_scrmcoupondb_coupon_marketing_t",
                "dwb_scrmcoupondb_coupon_record_d",
                "dwb_scrmcoupondb_coupon_template_t",
                "dwb_scrmcoupondb_coupon_use_record_d",
                "dwb_scrmmarketingdb_customer_life_cycle_card_level_r",
                "dwb_scrmmarketingdb_customer_life_cycle_city_r",
                "dwb_scrmmarketingdb_customer_life_cycle_event_r",
                "dwb_scrmmarketingdb_customer_life_cycle_r",
                "dwb_scrmmarketingdb_customer_life_cycle_trigger_rule_r",
                "dwb_scrmmessagedb_sms_sys_send_record_d",
                "dwb_scrmmessagedb_wechat_msg_send_record_d",
                "dwb_supportdb_area_t",
                "dwb_supportdb_brand_t",
                "dwb_supportdb_data_dictionary_t",
                "dwb_supportdb_queuing_record_d",
                "dwb_supportdb_shop_t",
                "dwb_supportdb_shop_table_t",
                "dwb_supportdb_shop_work_time_t",
                "dwb_xmdcomment_food_product_t",
                "dwb_xmdcomment_salary_bypiece_t"
        );
        return list;
    }

}
