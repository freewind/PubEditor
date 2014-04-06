    package com.thoughtworks.pli.pub_editor;

    import com.intellij.openapi.actionSystem.AnAction;
    import com.intellij.openapi.actionSystem.AnActionEvent;
    import com.intellij.openapi.actionSystem.PlatformDataKeys;
    import com.intellij.openapi.project.Project;
    import com.intellij.openapi.ui.Messages;

    public class HelloWorldAction extends AnAction {

    //        // If you register the action from Java code, this constructor is used to set the menu item name
    //        // (optionally, you can specify the menu description and an icon to display next to the menu item).
    //        // You can omit this constructor when registering the action in the plugin.xml file.
    //        public HelloWorldAction() {
    //            // Set the menu item name.
    //            super("_Hello world");
    //            // Set the menu item name, description and icon.
    //            // super("Text _Boxes","Item description",IconLoader.getIcon("/Mypackage/icon.png"));
    //        }

        @Override
        public void actionPerformed(AnActionEvent event) {
            Project project = event.getData(PlatformDataKeys.PROJECT);
            String userName = askForName(project);
            sayHello(project, userName);
        }

        private String askForName(Project project) {
            return Messages.showInputDialog(project,
                    "What is your name?", "Input Your Name",
                    Messages.getQuestionIcon());
        }

        private void sayHello(Project project, String userName) {
            Messages.showMessageDialog(project,
                    String.format("Hello, %s!\n Welcome to PubEditor.", userName), "Information",
                    Messages.getInformationIcon());
        }

    }
