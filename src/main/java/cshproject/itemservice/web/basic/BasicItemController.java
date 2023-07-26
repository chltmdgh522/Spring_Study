package cshproject.itemservice.web.basic;

import cshproject.itemservice.domain.item.Item;
import cshproject.itemservice.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
public class BasicItemController {
    private final ItemRepository itemRepository;

    @Autowired
    public BasicItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public String items(Model model){
        List<Item> items= itemRepository.findAll();
        model.addAttribute("items",items);
        return "/basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm(){
        return "/basic/addForm";
    }

    //@PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                       @RequestParam int price,
                       @RequestParam Integer quantity,
                       Model model){
        Item item=new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.save(item);
        model.addAttribute("item",item);
        return "/basic/item";
    }

    //@PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item,
                            Model model){
        itemRepository.save(item);
       // model.addAttribute("item",item); 자동추가되서 생략 가능
        return "/basic/item";
    }

   // @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item){
        //이름 지정안하면 클래스이름 앞글자만 소문자 되서 강제로 집어넣음
        itemRepository.save(item);
        // model.addAttribute("item",item); 자동추가되서 생략 가능
        return "/basic/item";
    }

    //@PostMapping("/add")
    public String addItemV5(@ModelAttribute Item item){
        //이름 지정안하면 클래스이름 앞글자만 소문자 되서 강제로 집어넣음
        itemRepository.save(item);
        // model.addAttribute("item",item); 자동추가되서 생략 가능
        return "redirect:/basic/items/" + item.getId();
    }

    @PostMapping("/add")
    public String addItemV6(@ModelAttribute Item item, RedirectAttributes redirectAttributes){
        //이름 지정안하면 클래스이름 앞글자만 소문자 되서 강제로 집어넣음
        Item savedItem = itemRepository.save(item);
        // model.addAttribute("item",item); 자동추가되서 생략 가능
        redirectAttributes.addAttribute("itemId",savedItem.getId());
        redirectAttributes.addAttribute("status",true);
        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "/basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item){
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}";
    }

    /*테스트 */
    @PostConstruct
    public void init(){
        itemRepository.save(new Item("승호의 공책",12000,3));
        itemRepository.save(new Item("승호의 연필",11000,2));
    }
}